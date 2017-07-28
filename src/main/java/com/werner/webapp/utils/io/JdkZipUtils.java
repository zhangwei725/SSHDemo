package com.werner.webapp.utils.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 基于JDK的Zip压缩工具类
 * 存在问题：压缩时如果目录或文件名含有中文，压缩后会变成乱码
 *
 */
public class JdkZipUtils {

	public static final int BUFFER_SIZE_DIFAULT = 1024;

	/**
	 * 
	 * @param inFilePaths
	 * @param zipFilePath
	 * @throws Exception
	 */
	public static void makeZip(String[] inFilePaths, String zipFilePath)
			throws Exception {
		File[] inFiles = new File[inFilePaths.length];
		for (int i = 0; i < inFilePaths.length; i++) {
			inFiles[i] = new File(inFilePaths[i]);
		}
		makeZip(inFiles, zipFilePath);
	}

	/**
	 * 
	 * @param inFiles
	 * @param zipFilePath
	 * @throws Exception
	 */
	public static void makeZip(File[] inFiles, String zipFilePath)
			throws Exception {
		ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(
				new FileOutputStream(zipFilePath)));
		for (int i = 0; i < inFiles.length; i++) {
			doZipFile(zipOut, inFiles[i], inFiles[i].getParent());
		}
		zipOut.flush();
		zipOut.close();
	}

	/**
	 * 
	 * @param zipOut
	 * @param file
	 * @param dirPath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void doZipFile(ZipOutputStream zipOut, File file,
			String dirPath) throws FileNotFoundException, IOException {
		if (file.isFile()) {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));
			String zipName = file.getPath().substring(dirPath.length());
			while (zipName.charAt(0) == '\\' || zipName.charAt(0) == '/') {
				zipName = zipName.substring(1);
			}
			ZipEntry entry = new ZipEntry(zipName);
			zipOut.putNextEntry(entry);
			byte[] buff = new byte[BUFFER_SIZE_DIFAULT];
			int size;
			while ((size = bis.read(buff, 0, buff.length)) != -1) {
				zipOut.write(buff, 0, size);
			}
			zipOut.closeEntry();
			bis.close();
		} else {
			File[] subFiles = file.listFiles();
			for (File subFile : subFiles) {
				doZipFile(zipOut, subFile, dirPath);
			}
		}
	}

	/**
	 * 
	 * @param zipFilePath
	 * @param storePath
	 * @throws IOException
	 */
	public static void unZip(String zipFilePath, String storePath)
			throws IOException {
		unZip(new File(zipFilePath), storePath);
	}

	/**
	 * 
	 * @param zipFile
	 * @param storePath
	 * @throws IOException
	 */
	public static void unZip(File zipFile, String storePath) throws IOException {
		if (new File(storePath).exists()) {
			new File(storePath).delete();
		}
		new File(storePath).mkdirs();

		ZipFile zip = new ZipFile(zipFile);
		Enumeration<? extends ZipEntry> entries = zip.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();

			if (zipEntry.isDirectory()) {
			} else {
				String zipEntryName = zipEntry.getName();
				if (zipEntryName.indexOf(File.separator) > 0) {
					String zipEntryDir = zipEntryName.substring(0, zipEntryName
							.lastIndexOf(File.separator) + 1);
					String unzipFileDir = storePath + File.separator
							+ zipEntryDir;
					File unzipFileDirFile = new File(unzipFileDir);
					if (!unzipFileDirFile.exists()) {
						unzipFileDirFile.mkdirs();
					}
				}

				InputStream is = zip.getInputStream(zipEntry);
				FileOutputStream fos = new FileOutputStream(new File(storePath
						+ File.separator + zipEntryName));
				byte[] buff = new byte[BUFFER_SIZE_DIFAULT];
				int size;
				while ((size = is.read(buff)) > 0) {
					fos.write(buff, 0, size);
				}
				fos.flush();
				fos.close();
				is.close();
			}
		}
	}
	
	/**
	 * @param inputFileName 你要压缩的文件夹(整个完整路径)
	 * @param zipFileName 压缩后的文件(整个完整路径)
	 * @throws Exception
	 */
	public static Boolean zip(String inputFileName, String zipFileName) throws Exception {
		zip(zipFileName, new File(inputFileName));
		return true;
	}

	private static void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile, "");
		out.flush();
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			//System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}

	public static void main(String[] args) throws Exception {
		String rootDir = "D:\\chenfeng";
		File[] inFiles = new File(rootDir).listFiles();
		String zipPath = "D:\\ZipDemo.zip";

		makeZip(inFiles, zipPath);

		unZip(zipPath, "D:\\chenfeng_zip");
	}
}