package com.jero.esc.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 
 * <pre>
 * <b> 读取properties文件 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2018-2-5下午3:39:12
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018-2-5下午3:39:12         new file.
 * </pre>
 */
public class PropertiesUtil {
	/** 文件名称 */
	private static final String PROPERTIES_NAME = "commondata.properties";
	
	public static String getStr(String name){
		Properties properties = new Properties();
		FileInputStream in = null;
		try{
			in = new FileInputStream(PROPERTIES_NAME);
			properties.load(in);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("读取配置信息失败！");
			return null;
		}finally{
			if(in != null){
				try{
					in.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return properties.getProperty(name);
	}
	public  String  getUrlByKey(String key) {
		
		 InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("commondata.properties");
		 
		 Properties p = new Properties();
		 try {
			p.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Key~~~"+p.getProperty(key));
		return p.getProperty(key);
		
//		 System.out.println("attachurl:"+p.getProperty("attachurl")+",photour:"+p.getProperty("photour"));
	}
}
