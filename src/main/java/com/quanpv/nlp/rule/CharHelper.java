package com.quanpv.nlp.rule;


public class CharHelper {


    static final char[] vi_character = {
            'o', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ơ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ',
            'a', 'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
            'b', 'c', 'd', 'đ', 'e', 'è', 'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'g', 'h',
            'i', 'ì', 'í', 'ỉ', 'ĩ', 'ị', 'k', 'n', 'm', 'n', 't', 'u', 'ù', 'ú', 'ủ', 'ũ', 'ụ',
            'v', 'y', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ'
    };

    static final char[] phuAm = {
            'b', 'c', 'd', 'đ', 'g', 'h', 'k', 'n', 'm', 't', 'v'
    };

    static final char[] nguyenAm = {
            'o', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ơ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ',
            'a', 'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
            'e', 'è', 'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'i', 'ì', 'í', 'ỉ', 'ĩ', 'ị',
            'u', 'ù', 'ú', 'ủ', 'ũ', 'ụ', 'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'y', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ'
    };


    static final char[] nguyenAmCoDau = {
            'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ',
            'à', 'á', 'ả', 'ã', 'ạ', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
            'è', 'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'ì', 'í', 'ỉ', 'ĩ', 'ị',
            'ù', 'ú', 'ủ', 'ũ', 'ụ', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ'
    };

    static final String[] boBaNguyenAm = {
            "iêu", "iều", "iếu", "iểu", "ễu", "iệu", "yêu", "yều", "yếu", "yểu", "yễu", "yệu", "oai", "oài", "oao",
            "oay", "oeo", "uao", "uay", "iới", "iai", "ười", "oái", "oại", "oải", "uyể", "iáo", "uái", "iỏi", "uẹo",
            "uây", "uôi", "uồi", "uối", "uổi", "uỗi", "uội", "ươi", "ươu", "uya", "uyê", "uyệ", "uyề", "uyế", "uyu",
            "uảy", "iao", ""
    };

    /**
     * kiểm tra một chữ cái có phải là nguyên âm không
     * @param c
     * @return
     */
    public static boolean isNguyenAm(char c) {
        for (char na : nguyenAm) {
            if (c == na)
                return true;
        }
        return false;
    }


    /**
     * kiểm tra một chữ cái có phải là phụ âm không
     * @param c
     * @return
     */
    public static boolean isPhuAm(char c) {
        for (char pa : phuAm) {
            if (c == pa)
                return true;
        }
        return false;
    }


    /**
     * Kiểm tra một chữ cái có thuộc bảng chữ cái tiếng việt không
     * @param c
     * @return
     */
    public static boolean isVietnamCharacter(char c) {

        for (char vi : vi_character) {
            if (vi == c) {
                return true;
            }
        }
        return false;
    }
    /**
     * kiểm tra một chữ cái có phải là nguyên âm không
     * @param c
     * @return
     */
    public static boolean isNguyenAmCoDau(char c) {
        for (char na : nguyenAmCoDau) {
            if (c == na)
                return true;
        }
        return false;
    }

}
