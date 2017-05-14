package com.quanpv.nlp.rule;


public class CharHelper {


    static final char[] vi_character = {
            'o', 'ò', 'ó', 'ỏ', 'õ', 'ọ', 'ô', 'ồ', 'ố', 'ổ', 'ỗ', 'ộ', 'ơ', 'ờ', 'ớ', 'ở', 'ỡ', 'ợ',
            'a', 'à', 'á', 'ả', 'ã', 'ạ', 'ă', 'ằ', 'ắ', 'ẳ', 'ẵ', 'ặ', 'â', 'ầ', 'ấ', 'ẩ', 'ẫ', 'ậ',
            'b', 'c', 'd', 'đ', 'e', 'è', 'é', 'ẻ', 'ẽ', 'ẹ', 'ê', 'ề', 'ế', 'ể', 'ễ', 'ệ', 'g', 'h',
            'i', 'ì', 'í', 'ỉ', 'ĩ', 'ị', 'k', 'n', 'm', 'n', 't', 'u', 'ù', 'ú', 'ủ', 'ũ', 'ụ',
            'ư', 'ừ', 'ứ', 'ử', 'ữ', 'ự', 'v', 'y', 'ỳ', 'ý', 'ỷ', 'ỹ', 'ỵ', 'p', 'q', 'r', 'x', 'l', 's'
    };

    static final char[] phuAm = {
            'b', 'c', 'd', 'đ', 'g', 'h', 'k', 'n', 'm', 'l', 'x', 't', 'v', 's',
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
            "iêu", "iều", "iếu", "iểu", "iễu", "iệu",
            "yêu", "yều", "yếu", "yểu", "yễu", "yệu",
            "oai", "oài", "oái", "oải", "oãi", "oại",
            "oay", "oày", "oáy", "oảy", "oãy", "oạy",
            "oeo", "uao",
            "iơi", "iời", "iới", "iởi", "iỡi", "iợi",
            "uay",
            "uây", "uôi", "uồi", "uối", "uổi", "uỗi", "uội",
            "ươi", "ươu", "uya", "uyê", "uyệ", "uyề", "uyế", "uyu",
            "uảy", "iao", "iũa", "iẩy", "iuộc",
            "ươi", "ưới", "ười", "ượi", "ưởi",
            "iảo", "iải", "uơi",
            "iai", "ười", "uyể", "iáo", "uái", "iỏi", "uẹo",
            "iậu", "oáy", "ưỡi", "ưới", "ướu",
            "iồi", "uậy", "ườu","iây", "iãy", "iứa",
            "iươ"
    };

    static final String[] boDoiNguyenAm = {
            "ai", "ài", "ái", "ải", "ãi", "ại",
            "ao", "ào", "áo", "ảo", "ão", "ạo",
            "au", "àu", "áu", "ảu", "ãu", "ạu",
            "âu", "ầu", "ấu", "ẩu", "ẫu", "ậu",
            "ay", "ày", "áy", "ảy", "ãy", "ạy",
            "ây", "ầy", "ấy", "ẩy", "ẫy", "ậy",
            "eo", "èo", "éo", "ẻo", "ẽo", "ẹo",
            "êu", "ều", "ếu", "ểu", "ễu", "ệu",
            "ia", "ìa", "ía", "ỉa", "ĩa", "ịa",
            "iấ",
            "iê", "iề", "iế", "iể", "iễ", "iệ",
            "yê", "yề", "yế", "yể", "yễ", "yệ",
            "iu", "ìu", "íu", "ỉu", "ĩu", "ịu",
            "oa", "òa", "óa", "ỏa", "õa", "ọa",
            "oạ", "oà", "oá", "oả", "oã",
            "oă", "oắ", "oặ", "oằ",
            "oe", "òe", "óe", "ỏe", "õe", "ọe",
            "oẹ", "oé",
            "oi", "òi", "ói", "ỏi", "õi", "ọi",
            "ôi", "ồi", "ối", "ổi", "ỗi", "ội",
            "ơi", "ời", "ới", "ởi", "ỡi", "ợi",
            "oo",
            "ua", "ùa", "úa", "ủa", "ũa", "ụa",
            "uă", "uằ", "uắ", "uẳ", "uẵ", "uặ",
            "uâ", "uầ", "uấ", "uẩ", "uẫ", "uậ",
            "ưa", "ừa", "ứa", "ửa", "ữa", "ựa",
            "uê", "uề", "uế", "uể", "uễ", "uệ",
            "ui", "ùi", "úi", "ủi", "ũi", "ụi",
            "uí",
            "ưi", "ừi", "ứi", "ửi", "ữi", "ựi",
            "uo",
            "uá", "uả", "uã", "uạ", "uà",
            "uô", "uồ", "uố", "uổ", "uỗ", "uộ",
            "ươ", "ướ", "ườ","ưở", "ưỡ", "ượ",
            "ưu", "ứu", "ừu", "ửu", "ữu", "ựu",
            "uy", "ùy", "úy", "ủy", "ũy", "ụy",
            "uỳ", "uý", "uỷ", "uỹ", "uỵ"
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
