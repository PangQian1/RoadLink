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

import generateTopology.Main;

public class KeyRoadExtract {

	private static String linkToODPath="I:/pangqian/roadLink/linkToOD/";
	private static String keyRoadExtractPath = "I:/pangqian/roadLink/关键路段提取/";
	
	public static void main(String[] args) {
		keyRoadExtract(linkToODPath, keyRoadExtractPath);
	}

	
	/**
	 * 以路链值为目录，以通行量为value
	 */
	public static void keyRoadExtract(String linkToODPath, String keyRoadExtractPath) {
			
		File file = new File(linkToODPath);
		List<String> list = Arrays.asList(file.list());
		
		for(int i = 0; i < list.size(); i++) {		
			String pathIn = linkToODPath + list.get(i);
			
			Map<String,String> keyRoadMap=new HashMap<>();
			
			BufferedReader reader = Main.getReader(pathIn, "utf-8");
			String line = "";
			try {
				System.out.println(pathIn + "  start reading....");
				while((line = reader.readLine()) != null){
					String[] data = line.split(":",2);
					String[] ODInfo = data[1].split(";");
					int num = 0;
					
					for(int j=0; j<ODInfo.length; j++) {
						String[] info = ODInfo[j].split(",");
						//if(info.length < 3)System.out.println(data[1]);
						int txl = Integer.parseInt(info[2]);
						num += txl;
					}
					
					keyRoadMap.put(data[0], num+"");	
				}
				System.out.println(pathIn + "  read finish!");
			
				String outPath =  keyRoadExtractPath + list.get(i);
				System.out.println(outPath + "  start writing....");
				writeRes(keyRoadMap, outPath);
				
				System.out.println(outPath + "  write finish!");
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}	
		
		
	}
	
	public static void writeRes(Map<String, String>map, String path){

		try {
			OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(path), "utf-8");
			BufferedWriter writer = new BufferedWriter(writerStream);
			for(String id:map.keySet()){	
				writer.write(id + "," + map.get(id) + "\n");
			}

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
