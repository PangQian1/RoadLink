package pq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.streaming.examples.Outlining;

import generateTopology.Main;

public class LinkToOD {
	
	//private static String nameOdLink="I:/pangqian/roadLink/outTopology/浙江中间文件/zhejiangnameOdLink.csv";
	//private static String linkToODPath="I:/pangqian/roadLink/linkToOD/浙江/zhejiangLinkToOd.csv";
	private static String odToLinkTxlPath = "I:/pangqian/roadLink/outTopology/odToLink_txl/";
	private static String linkToODPath="I:/pangqian/roadLink/linkToOD/";
	
	public static void main(String[] args) {
		
		linkToOD(odToLinkTxlPath, linkToODPath);
	}
	
	/**
	 * 倒排索引，以路链值为目录，以OD为value，组织数据
	 * @param inOdLink
	 * @param outLinkToOd
	 */
	public static void linkToOD(String odToLinkTxlPath, String linkToODPath){
		
		File file = new File(odToLinkTxlPath);
		List<String> list = Arrays.asList(file.list());
		
		for(int i = 0; i < list.size(); i++) {		
			String pathIn = odToLinkTxlPath + list.get(i);
			
			Map<String,List<String>> linkToOdMap=new HashMap<>();
			
			BufferedReader reader = Main.getReader(pathIn, "utf-8");
			String line = "";
			try {
				System.out.println(pathIn + "  start reading....");
				while((line = reader.readLine()) != null){
					String[] data = line.split(";",2);
					String ODInfo = data[0].replaceAll("收费站", "");
					String[] linkPath = data[1].split(",");
					
					for(int j=0; j<linkPath.length; j++){
						if(linkToOdMap.containsKey(linkPath[j])){
							List<String> ODList = linkToOdMap.get(linkPath[j]);
							if(!ODList.contains(ODInfo)){
								ODList.add(ODInfo);
								linkToOdMap.put(linkPath[j], ODList);
							}
						}else{
							List<String> ODList = new ArrayList<>();
							ODList.add(ODInfo);
							linkToOdMap.put(linkPath[j], ODList);
						}
					}
					
				}
				System.out.println(pathIn + "  read finish!");
			
				String outPath = linkToODPath + list.get(i);
				System.out.println(outPath + "  start writing....");
				writeRes(linkToOdMap, outPath);
				
				System.out.println(outPath + "  write finish!");
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
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
