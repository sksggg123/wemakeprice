package com.kwon.web.Service;

import com.kwon.web.VO.ResponseVO;

import java.util.List;

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
public interface CharacterClassificationService {

    ResponseVO getQuotientAndRemainder(String str, int range);
}
