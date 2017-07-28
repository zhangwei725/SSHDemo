package com.werner.webapp.controller;

import com.alibaba.fastjson.JSONObject;
import com.werner.webapp.domain.Result;
import com.werner.webapp.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * advert_id : 319
 * advertTitle : app大迁移图
 * advertImg : http://yueshi.b0.upaiyun.com/adv/2017/06/14/8b165466e774a5a05e395a499d65388b_297.jpg
 * advertText :
 * advertUrl : https://shop150561197.taobao.com/shop/view_shop.htm?spm=a1z09.1.a1zvx.d53.w3T40X&amp;mytmenu=mdianpu&amp;user_number_id=2581027594
 * advertVideoUrl : null
 * videoShareUrl : http://api.yueshichina.com/html/share/videoDisplay.html
 * isMark : 0
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @Resource
    HomeService homeService;

    @RequestMapping("/add")
    @ResponseBody
    public String test() {
//        ArrayList arrayList = new ArrayList();
//
//        Banner banner = new Banner(
//                "319",
//                "测试数据",
//                "http://yueshi.b0.upaiyun.com/adv/2017/06/14/8b165466e774a5a05e395a499d65388b_297.jpg",
//                "测试数据",
//                "",
//                "http://api.yueshichina.com/html/share/videoDisplay.html"
//        );
//        arrayList.add(banner);
//        homeService.saveBanners(arrayList);

        String url = "http://interface.yueshichina.com/?act=app&op=index1&client=android&curpage=1&token=749a036dc06ae8b3a120848995a9f306&key=f5492f263ab68e5b9c85b2a26c6f820e";
        String dataString = getDataString(url);
        Result result = JSONObject.parseObject(dataString, Result.class);
        homeService.saveData(result.getDatas());
        return "";
    }

    public String getDataString(String path) {
        String jsonString = null;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() == 200) {                //200表示请求成功
                InputStream is = conn.getInputStream();       //以输入流的形式返回
                //将输入流转换成字符串
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                jsonString = baos.toString();
                baos.close();
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @RequestMapping("/index")
    public void index(String page, String pageSize) {



    }


}
