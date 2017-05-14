package com.quanpv.nlp.rule;


public class Rule11 {
    /**
     * Nếu kết thúc bằng h thì phải là n hoặc c và trước đó phải là nguyên âm
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();

        int len = chars.length;

        if(len<2)
            return true;
        char last = chars[len - 1];
        if( last!='m'&&last!='n'&&last!='c'&&last!='t')
            return true;
        if(!CharHelper.isNguyenAm(chars[len-2])){
            return false;
        }
        return true;
    }

}
