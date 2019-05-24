package main.java.com.kwon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class WMPController {

    @RequestMapping(value = "/")
    public String main() {
        return "index";
    }
}
