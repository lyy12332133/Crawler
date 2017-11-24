package com.huawei.test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by dllo on 17/11/23.
 */
public class ImgDownloadUtils extends Thread {

    private String imgURL;
    private String imgName;

    public ImgDownloadUtils(String imgURL, String imgName) {
        this.imgURL = imgURL;
        this.imgName = imgName;
    }

    @Override
    public void run() {
        saveImg(imgURL, imgName);
    }

    // 下载图片的方法
    public void saveImg(String imgURL, String imgName) {
        // 下载
//            System.out.println(imgURL);
        // 具体下载的代码
        URL url = null;
        try {
            url = new URL(imgURL);
            URLConnection connection = url.openConnection();

            // 获取数据流
            InputStream is = connection.getInputStream();

            File file = new File("/Users/dllo/Desktop/img");
            if (!file.exists()) {
                file.mkdir();
            }
            OutputStream os = new FileOutputStream(new File("/Users/dllo/Desktop/img", imgName + ".png"));

            // 写入图片到本地
            byte[] buf = new byte[1024];
            int l = 0;

            while ((l = is.read(buf)) != -1) {
                os.write(buf, 0, l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
