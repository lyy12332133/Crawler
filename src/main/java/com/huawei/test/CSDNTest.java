package com.huawei.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by dllo on 17/11/23.
 */
public class CSDNTest {

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://blog.csdn.net/jackfrued/article/details/44921941#comments")
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.95 Safari/537.36")
                .get();
        Element article_content = document.getElementById("article_content");
        System.out.println(article_content);
//        Elements p = article_content.select("p");
//        for (int i = 0; i < p.size(); i++) {
//            Element element = p.get(i);
//            System.out.println(element.text());
//        }
    }
}
