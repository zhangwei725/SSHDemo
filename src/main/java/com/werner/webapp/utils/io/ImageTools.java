package com.werner.webapp.utils.io;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * remark: 用于图片处理

 */

public class ImageTools {

	public static final String PNG = "png";

	public static final String JPEG = "jpeg";

	public static final String JPG = "jpg";

	public static final String GIF = "gif";

	private ImageTools() {
		super();
		// TODO 自动生成构造函数存根
	}
	//------图片处理新方法-------------------------------
	public static BufferedImage resize(BufferedImage source, int targetW,
			int targetH) {
		// targetW，targetH分别表示目标长和宽
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
		// 则将下面的if else语句注释即可
		if (sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
					targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else
			target = new BufferedImage(targetW, targetH, type);
		Graphics2D g = target.createGraphics();
		// smoother than exlax:
		g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	public static void saveImageAsJpg(String fromFileStr, String saveToFileStr,	int width, int hight) throws Exception {
		BufferedImage srcImage;
		// String ex =
		// fromFileStr.substring(fromFileStr.indexOf("."),fromFileStr.length());
		String imgType = "JPEG";
		if (fromFileStr.toLowerCase().endsWith(".png")) {
			imgType = "PNG";
		}
		// System.out.println(ex);
		File saveFile = new File(saveToFileStr);
		File fromFile = new File(fromFileStr);
		srcImage = ImageIO.read(fromFile);
		if (width > 0 || hight > 0) {
			srcImage = resize(srcImage, width, hight);
		}
		ImageIO.write(srcImage, imgType, saveFile);

	}
	//-----------------------

	public static BufferedImage draw(String file, String tu) throws IOException {
		BufferedImage thumb = readImage(file);
		Graphics2D g = thumb.createGraphics();
		g.setColor(Color.red);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,	RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g.setFont(new Font("String",Font.PLAIN,30));
		g.drawString("TR", 180, 30);
		return thumb;
	}

	public static BufferedImage thumbFilter(BufferedImage source, int width,
			int height) {

		BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 处理缩放比例
		if (source.getWidth() / (double) width > source.getHeight() / (double) height) {
			height = (int) ((double) width * source.getHeight() / source.getWidth());
		} else {
			width = (int) ((double) height * source.getWidth() / source.getHeight());
		}

		Graphics2D g = thumb.createGraphics();

		g.setColor(new Color(255, 255, 255, 255));

		// g.drawRect(0, 0, thumb.getWidth(), thumb.getHeight());
		Image buf = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		g.drawImage(buf, (thumb.getWidth() - width) / 2,(thumb.getHeight() - height) / 2, null);

		// g.setColor(new Color(255, 255, 255, 200));

		// 设置平滑抗锯齿
		// g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		// g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		// RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		// g.drawString("By Robin", 0, 30);

		return thumb;
	}

	/**
	 * 读取图片
	 * 
	 * @param in
	 * @param type
	 *            png gif jpg
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage readImage(InputStream in, String type)
			throws IOException {

		Iterator readers = ImageIO.getImageReadersByFormatName(type);
		ImageReader reader = (ImageReader) readers.next();

		// Object source; // File or InputStream
		ImageInputStream iis = ImageIO.createImageInputStream(in);

		reader.setInput(iis, true);

		BufferedImage img = reader.read(0);

		return img;

	}

	public static BufferedImage readImage(String fileName) throws IOException {
		String type = fileName.substring(fileName.lastIndexOf(".") + 1);
		return readImage(new FileInputStream(fileName), type);
	}

	public static BufferedImage readImage(URL url) throws IOException {
		String type = url.toString().substring(
				url.toString().lastIndexOf(".") + 1);
		return readImage(url.openStream(), type);
	}

	public static BufferedImage readImage(File file) throws IOException {
		String type = file.getName().substring(
				file.getName().lastIndexOf(".") + 1);
		return readImage(new FileInputStream(file), type);
	}

	public static void writeImage(BufferedImage image, String filename)
			throws IOException {

		String type = filename.substring(filename.lastIndexOf(".") + 1);
		writeImage(image, type, filename);
	}

	public static void writeImage(BufferedImage image, String type,
			String filename) throws IOException {
		File f = new File(filename);
		writeImage(image, type, f);
	}

	public static void writeImage(BufferedImage image, String type, File file)
			throws IOException {

		Iterator writers = ImageIO.getImageWritersByFormatName(type);
		ImageWriter writer = (ImageWriter) writers.next();

		// Once an ImageWriter has been obtained, its destination must be set to
		// an ImageOutputStream:

		// File f = new File(filename);
		ImageOutputStream ios = ImageIO.createImageOutputStream(file);
		writer.setOutput(ios);

		// Finally, the image may be written to the output stream:

		writer.write(image);

	}
	
	/**
	 * 损失小一些
	  * 创建图片缩略图(等比缩放)
	  * @param src 源图片文件完整路径
	  * @param dist 目标图片文件完整路径
	  */
	@SuppressWarnings("restriction")
	public static void ratioZoom2(File src, File dist, double ratio0) {
		try {
			if (!src.exists()) {
				throw new NullPointerException("文件不存在");
			}
			BufferedImage image = ImageIO.read(src);

			// 获得缩放的比例
			double ratio = 0.0;
			if (image.getHeight() > 100 || image.getWidth() > 100) {
				if (image.getHeight() > image.getWidth()) {
					ratio = ratio0 / image.getHeight();
				} else {
					ratio = ratio0 / image.getWidth();
				}
			}
			// 计算新的图面宽度和高度
			int newWidth = (int) (image.getWidth() * ratio);
			int newHeight = (int) (image.getHeight() * ratio);

			BufferedImage bfImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			bfImage.getGraphics().drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0,
					null);

			FileOutputStream os = new FileOutputStream(dist);
			@SuppressWarnings("restriction")
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
			encoder.encode(bfImage);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		try {
			BufferedImage imageS = ImageTools.readImage("d:\\111.jpg");
			BufferedImage imageR = ImageTools.thumbFilter(imageS, 800,600);
			ImageTools.writeImage(imageR, "d\\222.jpg");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
