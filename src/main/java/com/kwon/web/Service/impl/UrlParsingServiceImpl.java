package com.kwon.web.Service.impl;

import com.kwon.web.Service.UrlParsingService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : wemakepricetest
 * create date  : 2019-05-25 03:04
 */
public class UrlParsingServiceImpl implements UrlParsingService {

    // html type method
    public String doUrlParsingFromHtml(String url) throws IOException{

        url = protocolInputCheck(url);
        String html = getConnect(url);
        String htmlReplace = getReplace(html);
        return htmlReplace;
    }

    // text type method
    public String doUrlParsingFromText(String url) throws IOException {

        url = protocolInputCheck(url);
        String text = getConnect(url);
        Document doc = Jsoup.parseBodyFragment(text);
        String textReplace = getReplace(doc.text());
        return textReplace;
    }

    // http, https 입력여부 체크
    private String protocolInputCheck(String url) {
        if(!url.startsWith("http://")
                && !url.startsWith("https://")) {

            url = "http://" + url;
        }
        return url;
    }

    // URL Connection
    private String getConnect(String url) throws IOException {

        URL targetUrl = new URL(url);
        URLConnection con = targetUrl.openConnection();
        con.setDoOutput(true);

        con.setRequestProperty("CONTENT-TYPE", "text/html");
        BufferedReader in = new BufferedReader(new InputStreamReader(targetUrl.openStream(), "utf-8"));
        String inputLine;
        String returnValue = "";

        while ((inputLine = in.readLine()) != null) {
            returnValue += inputLine.trim();
        }

        in.close();

        return returnValue;
    }

    // 문자추출
    private String getReplace(String html) {
        String reg = "\\W";
        String str = html.replaceAll(reg, "");
        str.trim();
        return str;
    }

}
