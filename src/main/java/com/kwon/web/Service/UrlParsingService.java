package com.kwon.web.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : wemakepricetest
 * create date  : 2019-05-25 02:50
 */
public interface UrlParsingService {

    String doUrlParsingFromHtml(String url) throws IOException;

    String doUrlParsingFromText(String url) throws IOException;

}
