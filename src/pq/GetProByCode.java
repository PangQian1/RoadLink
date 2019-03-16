package pq;

public class GetProByCode {
	
	public static String getRealeaser(String ProvinceCode) {
		switch (ProvinceCode) {
		case "05":
			return "����";
		case "11":
			return "����";
		case "12":
			return "���";
		case "31":
			return "�Ϻ�";
		case "50":
			return "����";
		case "64":
			return "����";
		case "65":
			return "�½�";
		case "15":
			return "���ɹ�";
		case "45":
			return "����";
		case "13":
			return "�ӱ�";
		case "14":
			return "ɽ��";
		case "21":
			return "����";
		case "22":
			return "����";
		case "23":
			return "������";
		case "32":
			return "����";
		case "33":
			return "�㽭";
		case "34":
			return "����";
		case "35":
			return "����";
		case "36":
			return "����";
		case "37":
			return "ɽ��";
		case "41":
			return "����";
		case "42":
			return "����";
		case "43":
			return "����";
		case "44":
			return "�㶫";
		case "51":
			return "�Ĵ�";
		case "52":
			return "����";
		case "53":
			return "����";
		case "61":
			return "����";
		case "62":
			return "����";
		case "63":
			return "�ຣ";
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
