package com.quanpv.nlp.rule;


public class Rule10 {
    /**
     * Nếu kết thúc bằng h thì phải là n hoặc c và trước đó phải là nguyên âm
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();

        int len = chars.length;

        if(len<3)
            return true;
        if( chars[len - 1]!='h')
            return true;

        if(chars[len-2]!='n'&&chars[len-2]!='c')
            return false;

        if(!CharHelper.isNguyenAm(chars[len-3])){
            return false;
        }
        return true;
    }

}
