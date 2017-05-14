package com.quanpv.nlp.rule;


public class Rule5 {

    /**
     * Không phải phụ âm nào cũng được phéo đứng cuối từ:
     * b, q, r, d, đ, s, k, l, v
     * @param s
     * @return
     */
    public static boolean isValid (String s){
        char lastChar = s.charAt(s.length() -1);
        char[] chars = {'b', 'q', 'r', 'd', 'đ', 's', 'k', 'l', 'v', 'x'};
        for(char c : chars) {
            if(lastChar== c) {
                return false;
            }
        }
        return true;
    }
}
