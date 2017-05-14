package com.quanpv.nlp.rule;



public class Rule3 {

    /**
     * Nếu có nhiều phụ âm thì tối đa là 5 phụ âm
     * @param s
     * @return
     */
    public static boolean isValid (String s) {

        char[] chars = s.toLowerCase().toCharArray();

        int soPhuAm = 0;
        for (char c: chars) {
            for (char na: CharHelper.phuAm) {
                if (c==na) {
                    soPhuAm++;
                }
            }
        }
        return (soPhuAm<=5)? true: false;
    }

}
