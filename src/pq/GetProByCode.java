package pq;

public class GetProByCode {

	public static String getRealeaser(String ProvinceCode) {
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
