package com.quanpv.nlp.rule;


public class Rule12 {
    /**
     * Nếu kết bắt đầu bằng n thì tiếp theo là h, g hoặc nguyên âm
     * nếu tiếp theo là h, g thì sau đó là nguyên âm
     * hoặc tiếp theo là nguyên âm
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();

        if(chars.length < 2) {
            return true;
        }

        char start = chars[0];
        if( start!='n') {
            return true;
        }

        if(CharHelper.isNguyenAm(chars[1])){
            return true;
        }
        else if(chars[1]=='h') {
            return CharHelper.isNguyenAm(chars[2]);
        }
        else if(chars[1]=='g') {
            if(chars[2]=='h'){
                return CharHelper.isNguyemAmSauNghOrGH(chars[3]);
            }
            return CharHelper.isNguyenAm(chars[2]);
        }
        return false;
    }

}
