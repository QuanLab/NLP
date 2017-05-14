package com.quanpv.nlp.rule;


public class Rule1 {

    /**
     * Nếu một từ chứa kỳ tự không có trong bảng chữ cái tiếng việt
     * thì sẽ coi là sai chính tả
     *
     * @param s
     * @return
     */
//    public static boolean isValid1(String s) {
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (c == 'f' || c == 'j' || c == 'w' || c == 'z') {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * Nếu một từ có ký tự unicode không nằm trong bảng chữ cái
     * thì sẽ coi la sai chính tả
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(!CharHelper.isVietnamCharacter(c)){
//                System.out.println(c);
                return false;
            }
        }
        return true;
    }
}
