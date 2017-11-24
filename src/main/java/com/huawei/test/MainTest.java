package com.huawei.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by dllo on 17/11/23.
 */
public class MainTest {

    @Test
    public void test1() {
        //爬虫测试
        String html = "<html><head><title>首页<title></head>" +
                "<body><p>这是一个页面</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.title());
    }

    @Test
    public void test2() {
        // 不完整的html
        String html = "<div><p>2222</p>";
        Document document = Jsoup.parseBodyFragment(html);
        System.out.println(document);
    }

    @Test
    public void test3() throws IOException {
        //根据URL进行获取document

        //https://www.csdn.net/

        Document document = Jsoup.connect("https://www.csdn.net/")
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36")
                .get();
        System.out.println(document.title());
    }

    @Test
    public void test4() throws IOException {
        //访问本地文件
        File input = new File("./src/main/webapp/WEB-INF/home.html");
        Document document = Jsoup.parse(input, "UTF-8");
        System.out.println(document);
        //Jsoup里面, 关于标签的操作, 和JS/JQ非常类似
        Element element = document.getElementById("div1");
        System.out.println(element);
        //获取标签的值
        //获取标签内的文本信息
        System.out.println(element.text());
        System.out.println(element.attr("id"));
        System.out.println(element.tagName());
        // 获取一组标签, 使用Elements
        Elements elements = document.getElementsByClass("divclass");
        System.out.println(elements.text());

    }

    @Test
    public void test5() throws IOException {
        File input = new File("./src/main/webapp/WEB-INF/home1.html");
        Document document = Jsoup.parse(input, "UTF-8");
        Elements elements = document.select("#div1");
        System.out.println(elements);
        Elements links = document.select("a[href]");
        System.out.println(links);
        System.out.println(links.attr("abs:href"));
    }

    @Test
    public void allLinks() throws IOException {
        Document document = Jsoup.connect("https://www.csdn.net/")
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36")
                .get();
        //1. a标签
        //2. 媒体文件
        //3. 引用文件
        Elements nav = document.select(".nav");
        Elements links = nav.select("a[href]");
        for (Element link : links) {
            System.out.println(link.attr("abs:href") + "      " + link.text());
        }
//        System.out.println(links);
        Elements media = document.select("[src]");
//        System.out.println(media);
        Elements imports = document.select("link[href]");
//        System.out.println(imports);
    }


}
