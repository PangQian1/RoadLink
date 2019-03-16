package pq;

public class GetProByCode {
	
	public static String getRealeaser(String ProvinceCode) {
		switch (ProvinceCode) {
		case "05":
			return "军车";
		case "11":
			return "北京";
		case "12":
			return "天津";
		case "31":
			return "上海";
		case "50":
			return "重庆";
		case "64":
			return "宁夏";
		case "65":
			return "新疆";
		case "15":
			return "内蒙古";
		case "45":
			return "广西";
		case "13":
			return "河北";
		case "14":
			return "山西";
		case "21":
			return "辽宁";
		case "22":
			return "吉林";
		case "23":
			return "黑龙江";
		case "32":
			return "江苏";
		case "33":
			return "浙江";
		case "34":
			return "安徽";
		case "35":
			return "福建";
		case "36":
			return "江西";
		case "37":
			return "山东";
		case "41":
			return "河南";
		case "42":
			return "湖北";
		case "43":
			return "湖南";
		case "44":
			return "广东";
		case "51":
			return "四川";
		case "52":
			return "贵州";
		case "53":
			return "云南";
		case "61":
			return "陕西";
		case "62":
			return "甘肃";
		case "63":
			return "青海";
		default:
			return "";
		}
	}

	public static String getRealeaserPinyin(String ProvinceCode) {
		switch (ProvinceCode) {
		case "05":
			return "junche";
		case "11":
			return "beijing";
		case "12":
			return "tianjin";
		case "31":
			return "shanghai";
		case "50":
			return "chongqing";
		case "64":
			return "ningxia";
		case "65":
			return "xinjiang";
		case "15":
			return "neimenggu";
		case "45":
			return "guangxi";
		case "13":
			return "hebei";
		case "14":
			return "shanxi";
		case "21":
			return "liaoning";
		case "22":
			return "jilin";
		case "23":
			return "heikongjiang";
		case "32":
			return "jiangsu";
		case "33":
			return "zhejiang";
		case "34":
			return "anhui";
		case "35":
			return "fujian";
		case "36":
			return "jiangxi";
		case "37":
			return "shandong";
		case "41":
			return "henan";
		case "42":
			return "hubei";
		case "43":
			return "hunan";
		case "44":
			return "guangdong";
		case "51":
			return "sichuan";
		case "52":
			return "guizhou";
		case "53":
			return "yunnan";
		case "61":
			return "shanxi";
		case "62":
			return "gansu";
		case "63":
			return "qinghai";
		default:
			return "";
		}
	}	
	
}
