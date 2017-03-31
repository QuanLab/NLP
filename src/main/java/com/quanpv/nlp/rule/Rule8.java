package com.quanpv.nlp.rule;

/**
 * Created by quanpv on 22/02/2017.
 */
public class Rule8 {

    /**
     * không phải nguyên âm nào cũng có thể tạo thành bộ 3
     * IÊU/YÊU, OAI, OAO, OAY, OEO, UAO, UÂY, UÔI, ƯƠI, ƯƠU, UYA, UYÊ, UYU
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

        if(soNguyenAm>=3){
            for(String boBa: CharHelper.boBaNguyenAm) {
                if(s.contains(boBa)){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
