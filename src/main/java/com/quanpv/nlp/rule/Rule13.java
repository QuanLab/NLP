package com.quanpv.nlp.rule;


public class Rule13 {
    /**
     * Nếu bắt đầu bằng c thì tiếp theo là h hoặc nguyên âm
     * nếu tiếp theo là h thì sau đó là nguyên âm
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();

        if(chars.length<2) {
            return true;
        }

        char start = chars[0];

        if( start!='c') {
            return true;
        }

        if(chars[1]=='h') {
            if(!CharHelper.isNguyenAm(chars[2])){
                return false;
            }
            return true;
        }
        else if(!CharHelper.isNguyenAm(chars[1])){
            return false;
        }
        return true;
    }

}
