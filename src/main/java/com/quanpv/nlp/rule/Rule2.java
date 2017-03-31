package com.quanpv.nlp.rule;



public class Rule2 {

    /**
     * trong tiếng việt có tối thiể một nguyên âm, tối đa 3 nguyên âm
     */
    public static boolean isValid(String word) {

        char[] chars = word.toLowerCase().toCharArray();

        int soNguyenAm = 0;
        for (char c: chars) {
            for (char na: CharHelper.nguyenAm) {
                if (c==na) {
                    soNguyenAm++;
                }
            }
        }

        return (soNguyenAm>=1 && soNguyenAm<=3)? true: false;
    }
}
