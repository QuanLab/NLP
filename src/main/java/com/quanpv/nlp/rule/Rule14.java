package com.quanpv.nlp.rule;


public class Rule14 {

    /**
     * không phải nguyên âm nào cũng có thể tạo thành bộ đôi
     * @param s
     * @return
     */
    public static boolean isValid (String s){

        char[] chars = s.toCharArray();
        int soNguyenAm = 0;
        for (char c: chars) {
            for (char na: CharHelper.nguyenAm) {
                if (c==na) {
                    soNguyenAm++;
                }
            }
        }

        if(soNguyenAm==2){
            for(String boBa: CharHelper.boDoiNguyenAm) {
                if(s.contains(boBa)){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
