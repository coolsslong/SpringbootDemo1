package com.ssl.springboot2thymeleaf.bean;

/**
 * 民族代码转换为对应的民族民称
 */
public class NationUtil {

    public static String MZDMUtil(String MZDM) {
        String result = "";
        switch (MZDM) {
            case "01":
                result = "汉族";
                break;
            case "02":
                result = "蒙古族";
                break;
            case "03":
                result = "回族";
                break;
            case "04":
                result = "藏族";
                break;
            case "05":
                result = "维吾尔族";
                break;
            case "06":
                result = "苗族";
                break;
            case "07":
                result = "彝族";
                break;
            case "08":
                result = "壮族";
                break;
            case "09":
                result = "布依族";
                break;
            case "10":
                result = "朝鲜族";
                break;
            case "11":
                result = "满族";
                break;
            case "12":
                result = "侗族";
                break;
            case "13":
                result = "瑶族";
                break;
            case "14":
                result = "白族";
                break;
            case "15":
                result = "土家族";
                break;
            case "16":
                result = "哈尼族";
                break;
            case "17":
                result = "哈萨克族";
                break;
            case "18":
                result = "傣族";
                break;
            case "19":
                result = "黎族";
                break;
            case "20":
                result = "傈僳族";
                break;
            case "21":
                result = "佤族";
                break;
            case "22":
                result = "畲族";
                break;
            case "23":
                result = "高山族";
                break;
            case "24":
                result = "拉祜族";
                break;
            case "25":
                result = "水族";
                break;
            case "26":
                result = "东乡族";
                break;
            case "27":
                result = "纳西族";
                break;
            case "28":
                result = "景颇族";
                break;
            case "29":
                result = "柯尔克孜族";
                break;
            case "30":
                result = "土族";
                break;
            case "31":
                result = "达斡尔族";
                break;
            case "32":
                result = "仫佬族";
                break;
            case "33":
                result = "羌族";
                break;
            case "34":
                result = "布朗族";
                break;
            case "35":
                result = "撒拉族";
                break;
            case "36":
                result = "毛难族";
                break;
            case "37":
                result = "仡佬族";
                break;
            case "38":
                result = "锡伯族";
                break;
            case "39":
                result = "阿昌族";
                break;
            case "40":
                result = "普米族";
                break;
            case "41":
                result = "塔吉克族";
                break;
            case "42":
                result = "怒族";
                break;
            case "43":
                result = "乌孜别克族";
                break;
            case "44":
                result = "俄罗斯族";
                break;
            case "45":
                result = "鄂温克族";
                break;
            case "46":
                result = "崩龙族";
                break;
            case "47":
                result = "保安族";
                break;
            case "48":
                result = "裕固族";
                break;
            case "49":
                result = "京族";
                break;
            case "50":
                result = "塔塔尔族";
                break;
            case "51":
                result = "独龙族";
                break;
            case "52":
                result = "鄂伦春族";
                break;
            case "53":
                result = "赫哲族";
                break;
            case "54":
                result = "门巴族";
                break;
            case "55":
                result = "珞巴族";
                break;
            case "56":
                result = "基诺族";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(MZDMUtil("01"));
    }
}
