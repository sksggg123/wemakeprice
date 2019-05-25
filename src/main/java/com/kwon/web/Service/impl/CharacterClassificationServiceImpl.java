package com.kwon.web.Service.impl;

import com.kwon.web.Service.CharacterClassificationService;
import com.kwon.web.VO.CharacterList;
import com.kwon.web.VO.ResponseVO;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : wemakepricetest
 * create date  : 2019-05-25 12:46
 */
public class CharacterClassificationServiceImpl implements CharacterClassificationService {

    public ResponseVO getQuotientAndRemainder(String str, int range) {

        CharacterList list = new CharacterList(range(str,range));

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int flag = characterCheck(ch);
            if(flag == 1) {
                list.setDigitCase(String.valueOf(ch));
            } else if(flag == 2) {
                list.setUpperCase(String.valueOf(ch));
            } else if(flag == 3) {
                list.setLowerCase(String.valueOf(ch));
            } else {
                // nothing
            }
        }

        list.sort();
        ResponseVO vo = new ResponseVO();
        vo.setQuotient(list.quotientToString());
        vo.setRemainder(list.remainderToString());

        return vo;
    }

    private int range(String str, int range) {
        int len = str.length();
        int quo = len / range;
        int rem = len % range;
        System.out.println(len + " -> " + quo + " " + rem);

        return (quo * range);
    }

    private int characterCheck(char ch) {
        if (Character.isDigit(ch)) {
            return 1;
        } else if (Character.isUpperCase(ch) == true) {
            return 2;
        } else if (Character.isLowerCase(ch) == true) {
            return 3;
        } else {
            return 4;
        }
    }

}
