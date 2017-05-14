package com.quanpv.nlp.rule;


public class Rule9 {

    /**
     * Nếu kết thúc bằng g, h thì phải là ng và trước đó phải là nguyên âm
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();

        int len = chars.length;

        if(len<3)
            return true;
        if( chars[len - 1]!='g')
            return true;

        if(chars[len-2]!='n')
            return false;

        if(!CharHelper.isNguyenAm(chars[len-3])){
            return false;
        }
        return true;
    }
}
