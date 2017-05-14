package com.quanpv.nlp.rule;


public class Rule7 {

    /**
     * nếu nhiều hơn một nguyên âm thì có tối đa 1 nguyên âm có dấu
     * @param s
     * @return
     */
    public static boolean isValid (String s){

        char[] chars = s.toLowerCase().toCharArray();
        int soNguyenAmCoDau=0;

        for (char c: chars) {
            if(CharHelper.isNguyenAmCoDau(c)){
                soNguyenAmCoDau++;
            }
        }

        return (soNguyenAmCoDau<=1);
    }
}
