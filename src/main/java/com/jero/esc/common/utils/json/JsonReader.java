package com.jero.esc.common.utils.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.alibaba.fastjson.JSON;;

/**
 * 本地json读取
* @ClassName: JsonReader 
* @Description: <>
* @author: blazh
* @date: 2016年11月15日下午4:32:57
* @version:
 */
public class JsonReader {
	
//	public static void main(String[] args) {
//		JSONObject re=JsonReader.readFromPath("WebContent/sss.json", "utf-8", JSONObject.class);
//		System.out.println(re.get("sasas"));
//	}
	
	
	public static <T extends JSON> T  readFromPath(String path, String charset, Class<T> t) throws IOException {
		FileInputStream input =null;		
		try {
			File file = new File(path);
			if (file.exists()) {
				input= new FileInputStream(file);
				byte[] buffer = new byte[1024 * 1024];
				int length = 0;
				int totleLength=0;
				StringBuffer strBuffer = new StringBuffer();
				while ((length = input.read(buffer)) > 0) {
					strBuffer.append(new String(buffer,totleLength,length, charset));
					totleLength+=length;
				}
				System.out.println(strBuffer.toString());
				return (T)JSON.parse(strBuffer.toString().trim());			
			}
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
