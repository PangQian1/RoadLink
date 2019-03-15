package pq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;


public class TXLMatch {
	
	private static String odToLinkOriginPath = "I:/pangqian/roadLink/outTopology/odToLink(origin)/";
	private static String odtxlPath = "I:/pangqian/roadLink/odtxl";
	private static String zhangXingTongPath = "I:/pangqian/roadLink/掌行通收费站.csv";
	private static String odToLinkPath = "I:/pangqian/roadLink/outTopology/odToLink/";
	
	public static void main(String[] args) {
		
		txlMatch(odToLinkOriginPath, odtxlPath, zhangXingTongPath, odToLinkPath);
	}
	
	public static void txlMatch(String odToLinkOriginPath, String odtxlPath, String zhangXingTongPath, String odToLinkPath) {
		
		Map<String,String> zhangXingTongMap = getZhangXingTongMap(zhangXingTongPath);
		
		File file = new File(odToLinkOriginPath);
		List<String> list = Arrays.asList(file.list());
	
		for(int i = 0; i < list.size(); i++) {		
			String pathIn = odToLinkOriginPath + list.get(i);
			int count = 0;
			
			Map<String, String> odLinkOriMap = getODLinkOriginMap(pathIn);
			Map<String, String> odPathMap = new HashMap<>();//最终生成的带有通行量的map,以  入口收费站，出口收费站，txl  为key，以路链构成的路径为value
			
			try {
				
				InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(odtxlPath), "utf-8");
				BufferedReader reader = new BufferedReader(inputStreamReader);
				
				String line = "";
				while((line = reader.readLine()) != null) {
					
					line = line.replaceAll("\\(", "").replaceAll("\\)", "");
					String data[] = line.split(",", 4);
					String enStationID = data[0];//入口收费站id
					String exStationID = data[1];
					String txl = data[3];//通行量
					
					if(zhangXingTongMap.containsKey(enStationID) && zhangXingTongMap.containsKey(exStationID)) {
						
						String enStation = zhangXingTongMap.get(enStationID);//入口收费站名称
						String exStation = zhangXingTongMap.get(exStationID);//出口收费站名称
						String od = enStation + "," + exStation;
						//System.out.println(od);
						if(odLinkOriMap.containsKey(od)) {
							String path = odLinkOriMap.get(od);
							odPathMap.put(od + "," + txl, path);
							count++;
						}
					
					}else {
						//System.out.println(enStationID + "  " + exStationID);
						//count++;
					}
					
				}
							
				reader.close();
				System.out.println(odtxlPath + " read finish!");
				
				int index = list.get(i).indexOf("name");
				String outPath =  odToLinkPath + list.get(i).substring(0, index) + ".csv";
				writeData(odPathMap, outPath);
				System.out.println(count);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
	}
	
	public static Map<String,String> getODLinkOriginMap(String odToLinkOriginPath) {
		
		Map<String, String> odLinkOriMap = new HashMap<>();
			
		try {
			
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(odToLinkOriginPath), "gbk");
			BufferedReader reader = new BufferedReader(inputStreamReader);
			
			String line = "";
			while((line = reader.readLine()) != null) {
				
				String data[] = line.split(";", 3);
				String enStation = data[0].replaceAll(" ", "");//入口收费站名称
				String exStation = data[1].replaceAll(" ", "");
				
				if(enStation.equals("收费站") || exStation.equals("收费站")) {
					continue;
				}
				
				//System.out.println(enStation + "," + exStation);
				odLinkOriMap.put(enStation + "," + exStation, data[2]);
				
			}
						
			reader.close();
			System.out.println(odToLinkOriginPath + " read finish!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return odLinkOriMap;
		
	}
	
	public static Map<String,String> getZhangXingTongMap(String zhangXingTongPath) {
		
		Map<String,String> zhangXingTongMap = new HashMap<>();
		
		try {
			
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(zhangXingTongPath), "gbk");
			BufferedReader reader = new BufferedReader(inputStreamReader);
			
			String line = reader.readLine();
			while((line = reader.readLine()) != null) {
				
				String data[] = line.split(",");
				String stationID = data[0].trim();//收费站ID
				String stationName = data[1].replaceAll(" ", "");//收费站名称
				
				zhangXingTongMap.put(stationID, stationName);
				
			}
						
			reader.close();
			System.out.println(zhangXingTongPath + " read finish!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return zhangXingTongMap;
		
	}
	
	public static void writeData(Map<String, String> map, String path) {
		
		try {
			OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(path), "utf-8");
			BufferedWriter writer = new BufferedWriter(writerStream);
			for(String id:map.keySet()){
				
				String linkList = map.get(id);
				writer.write(id + ";" + linkList + "\n");
			}

			writer.flush();
			writer.close();
			
			System.out.println(path + " write finish");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
