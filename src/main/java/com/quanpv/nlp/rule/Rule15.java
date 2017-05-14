package com.quanpv.nlp.rule;


public class Rule15 {
    /**
     * Nếu bắt đầu bằng r, m, x, h, d, v, s thì sau đó là nguyên âm
     * bắt đầu bằng q sau đó phải là u
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        char start = chars[0];

        if( start=='r'||start=='m'||start=='x'||start=='h'||start=='d'||start=='đ'
                ||start=='v'||start=='s'||start=='l') {
            if(!CharHelper.isNguyenAm(chars[1])){
                return false;
            }
        }

        if( start=='q') {
            if(chars[1]!='u'){
                return false;
            }
        }

        return true;
    }

}
