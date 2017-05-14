package com.quanpv.nlp.rule;


public class Rule16 {
    /**
     * Nếu bắt đầu bằng t, g thì tiếp theo là h hoặc nguyên âm
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

        if( start=='t') {
            if(chars[1]=='h'||chars[1]=='r') {
                if(!CharHelper.isNguyenAm(chars[2])){
                    return false;
                }
            }
            else if(!CharHelper.isNguyenAm(chars[1])){
                return false;
            }
        }
        else if( start=='g') {
            if(chars[1]=='h') {
                return CharHelper.isNguyemAmSauNghOrGH(chars[2]);
            }
            else if(!CharHelper.isNguyenAm(chars[1])){
                return false;
            }
        }

        return true;
    }

}
