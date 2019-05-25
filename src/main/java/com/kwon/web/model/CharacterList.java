package com.kwon.web.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : wemakepricetest
 * create date  : 2019-05-25 14:34
 */
public class CharacterList {

    private List<String> upperCase;
    private List<String> lowerCase;
    private List<String> digitCase;

    private StringBuilder quotient;
    private StringBuilder remainder;

    private int range;

    public CharacterList(int range) {
        this.upperCase = new ArrayList<String>();
        this.lowerCase = new ArrayList<String>();
        this.digitCase = new ArrayList<String>();
        this.quotient = new StringBuilder();
        this.remainder = new StringBuilder();
        this.range = range;

    }

    public void setUpperCase(String character) {
        this.upperCase.add(character);
    }
    public void setLowerCase(String character) {
        this.lowerCase.add(character);
    }
    public void setDigitCase(String character) {
        this.digitCase.add(character);
    }

    public String getUpperCase() {
        if(sizeOfUpperList() != 0) {
            --range;
            String cha = this.upperCase.get(0);
            this.upperCase.remove(0);
            return cha;
        } else {
            return "";
        }
    }
    public String getLowerCase() {
        if(sizeOfLowerList() != 0) {
            --range;
            String cha = this.lowerCase.get(0);
            this.lowerCase.remove(0);
            return cha;
        } else {
            return "";
        }
    }
    public String getDigitCase() {
        if(sizeOfDigitList() != 0) {
            --range;
            String cha = this.digitCase.get(0);
            this.digitCase.remove(0);
            return cha;
        } else {
            return "";
        }
    }

    public String quotientToString() {
        return this.quotient.toString();
    }
    public String remainderToString() {
        return this.remainder.toString();
    }

    public int sizeOfUpperList() {
        return this.upperCase.size();
    }
    public int sizeOfLowerList() {
        return this.lowerCase.size();
    }
    public int sizeOfDigitList() {
        return this.digitCase.size();
    }

    public void sort() {
        Collections.sort(this.upperCase);
        Collections.sort(this.lowerCase);
        Collections.sort(this.digitCase);

        // 0 -> Upper
        // 1 -> Digit
        // 2 -> Lower
        int targetFlag = 0;
        int cnt = 0;
        while(true) {
            int breakNum = sizeOfDigitList() + sizeOfLowerList() + sizeOfUpperList();
            if(breakNum <= 0) {
                break;
            }

            // 확인용 삭제예정
            System.out.println("Flag : " + targetFlag
                    + " | Digit: " + sizeOfDigitList()
                    + " | Lower: " + sizeOfLowerList()
                    + " | Upper : " + sizeOfUpperList()
                    + " [cnt] : " + (++cnt)
                    + " [range] : " + range );

            if(range > 0) {
                switch (targetFlag) {
                    case 0: this.quotient.append(getUpperCase());
                        break;
                    case 1: this.quotient.append(getDigitCase());
                        break;
                    case 2: this.quotient.append(getLowerCase());
                        break;
                }
            } else {
                switch (targetFlag) {
                    case 0: this.remainder.append(getUpperCase());
                        break;
                    case 1: this.remainder.append(getDigitCase());
                        break;
                    case 2: this.remainder.append(getLowerCase());
                        break;
                }
            }
            targetFlag = mixTargetList(targetFlag);
        }
    }

    private int mixTargetList(int flag) {
        if(flag == 0) {
            if(this.sizeOfDigitList() != 0) {
                return 1;
            } else if (this.sizeOfLowerList() != 0){
                return 2;
            } else {
                return 0;
            }
        } else if(flag == 1) {
            if(this.sizeOfUpperList() != 0) {
                return 0;
            } else if (this.sizeOfLowerList() != 0) {
                return 2;
            } else  {
                return 1;
            }
        } else {
            if(this.sizeOfUpperList() != 0) {
                return 0;
            } else if(this.sizeOfDigitList() != 0) {
                return 1;
            } else {
                return 2;
            }
        }
    }



}
