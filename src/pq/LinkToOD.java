package pq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import generateTopology.Main;

public class LinkToOD {
	
	private static String nameOdLink="I:/pangqian/roadLink/outTopology/浙江中间文件/zhejiangnameOdLink.csv";
	private static String linkToODPath="I:/pangqian/roadLink/linkToOD/浙江/zhejiangLinkToOd.csv";
	
	public static void main(String[] args) {
		
		linkToOD(nameOdLink, linkToODPath);
	}
	
	/**
	 * 倒排索引，以路链值为目录，以OD为value，组织数据
	 * @param inOdLink
	 * @param outLinkToOd
	 */
	public static void linkToOD(String inOdLink, String outLinkToOd){
		
		Map<String,List<String>> linkToOdMap=new HashMap<>();
		
		BufferedReader reader = Main.getReader(inOdLink, "GBK");
		String line = "";
		try {
			System.out.println(inOdLink + "  start reading....");
			while((line = reader.readLine()) != null){
				String[] data=line.split(";",3);
				String inStationName=data[0];
				String outStationName=data[1];
				String OD = inStationName + "," + outStationName;//OD内部用逗号分隔，OD之间用分号分隔
				String[] linkPath=data[2].split(",");
				
				for(int i=0; i<linkPath.length; i++){
					if(linkToOdMap.containsKey(linkPath[i])){
						List<String> list = linkToOdMap.get(linkPath[i]);
						if(!list.contains(OD)){
							list.add(OD);
							linkToOdMap.put(linkPath[i], list);
						}
					}else{
						List<String> list=new ArrayList<>();
						list.add(OD);
						linkToOdMap.put(linkPath[i], list);
					}
				}
				
			}
			System.out.println(inOdLink + "  read finish!");
			System.out.println(outLinkToOd + "  start writing....");
			
			writeRes(linkToOdMap, outLinkToOd);
			
			System.out.println(outLinkToOd + "  write finish!");
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeRes(Map<String, List<String>>map, String path){

			try {
				OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(path), "utf-8");
				BufferedWriter writer = new BufferedWriter(writerStream);
				for(String id:map.keySet()){
					List<String> list = map.get(id);
					writer.write(id+":");
					for(int j=0;j<list.size();j++){
						if(j < (list.size()-1)){
							writer.write(list.get(j)+";");
						}else{
							writer.write(list.get(j)+"\n");
						}				
					}
				}

				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
