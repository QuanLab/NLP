package com.quanpv.nlp.rule;

/**
 * Created by quanpv on 22/02/2017.
 */
public class Rule4 {

    /**
     * nếu chữ cái có hai nguyên âm trở nên thì giữa chúng không được có phụ âm ở giữa
     * @param s
     * @return
     */
    public static boolean isValid (String s) {
        char[] chars = s.toLowerCase().toCharArray();

        int soNguyenAm = 0;
        for (char c: chars) {
            for (char na: CharHelper.nguyenAm) {
                if (c==na) {
                    soNguyenAm++;
                    continue;
                }
            }
        }

        if(soNguyenAm>=2 && soNguyenAm<=3){

            if(soNguyenAm==2){
                for(int i=0; i<chars.length; i++) {
                    if(CharHelper.isNguyenAm(chars[i])){
                        if(!CharHelper.isNguyenAm(chars[i+1])){
                            return false;
                        }
                        // thoat vong lap khi xet xong chu cai dau tien la nguyen am
                        break;
                    }
                }
            } else if(soNguyenAm==3){
                for(int i=0; i<chars.length; i++) {
                    //
                    if(CharHelper.isNguyenAm(chars[i])){
                        if(!CharHelper.isNguyenAm(chars[i+1])||!CharHelper.isNguyenAm(chars[i+2]) ){
                            return false;
                        }
                        // thoat vong lap khi xet xong chu cai dau tien la nguyen am
                        break;
                    }
                }
            }

        }
        return true;
    }
}
