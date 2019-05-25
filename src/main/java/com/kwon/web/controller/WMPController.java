package com.kwon.web.controller;

import com.kwon.web.Service.CharacterClassificationService;
import com.kwon.web.Service.UrlParsingService;
import com.kwon.web.VO.RequestVO;
import com.kwon.web.VO.ResponseVO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : wemakepricetest
 * create date  : 2019-05-24 23:30
 */
@Controller
@CrossOrigin(origins = "*")
public class WMPController {

    @Resource
    private UrlParsingService urlParsing;

    @Resource
    private CharacterClassificationService characterClassification;

    @RequestMapping(value = "/")
    public String main() {

        return "main";
    }

    @RequestMapping(value = "/print", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String print(RequestVO vo, Model model) throws IOException {

        String url = vo.getUrl();
        String type = vo.getType();
        String num = vo.getNum();
        String content = "";

        if(type.equals("html")) {
            content = urlParsing.doUrlParsingFromHtml(url);
        } else {
            content = urlParsing.doUrlParsingFromText(url);
        }


        ResponseVO resVO = characterClassification.getQuotientAndRemainder(content, Integer.parseInt(num));

        model.addAttribute("content", resVO);
        return "main";
    }
}
