package com.quanpv.nlp.rule;

/**
 * Created by quanpv on 22/02/2017.
 */
public class Rule6 {

    /**
     * không phải nguyên âm nào cũng được phép đứng trước
     * t, c, p. Xác định các nguyên âm đó
     * @param s
     * @return
     */
    public static boolean isValid (String s){

        char[] nguyenAmViPham = {'à', 'ã', 'ả', 'ồ','ổ', 'ỗ', 'ở', 'ỡ', 'ở', 'ì', 'ĩ', 'ỉ', 'ừ', 'ữ', 'ử', 'ỳ', 'ỷ', 'ỹ'};
        char[] chars = s.toLowerCase().toCharArray();
        for(int i=1; i< chars.length; i++){
            if(chars[i]=='t'|| chars[i]=='c' || chars[i]=='p'){
                for(char c: nguyenAmViPham){
                    if (c==chars[i-1])
                        return false;
                }
            }
        }
        return true;
    }
}
