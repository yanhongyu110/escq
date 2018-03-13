package com.jero.esc.common.utils.wx;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


public class TokenMapCollection {
	
	private static long CLEAR_TIME=60000*10;
	private static long TIME_OUT=60000;
	
	private static Map<String, UserTokenModel>userTokenMap=new ConcurrentHashMap<String, UserTokenModel>();
	
	private class UserTokenModel{
		private long creatTime;
		private String json;
	}
	
	private static Thread thread=new Thread(){
		@Override
		public void run() {
			while(true){				
				try {
					Thread.sleep(CLEAR_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				long date=new  Date().getTime();						
//				while(true){
//					synchronized (userTokenMap) {			
						System.out.println("��ʼ����*******************************************************");			
						for (Entry<String, UserTokenModel> iterable_element : userTokenMap.entrySet()) {
							if ( (date-iterable_element.getValue().creatTime)>TIME_OUT) {
							 userTokenMap.remove(iterable_element.getKey());								
							}
						}						
						System.out.println("�������***********************************************************");
//						break;
//					}				
//				}										
			}
		};
	};
	
	/**
	 * ��ʼ����
	 * @Description: <TODO>
	 * @return void
	 * @throws
	 */
	public static void start(){
		thread.start();
	}
	
	
	/**
	 * ����һ����ʶ
	 * @Description: <TODO>
	 * @return void
	 * @throws
	 */
	public static void  setFlag(String flag){		
		long date=new  Date().getTime();
		UserTokenModel model=new  TokenMapCollection().new UserTokenModel();
		model.creatTime=date;
		model.json=null;			
//		while(true){
//			synchronized (userTokenMap) {		
				userTokenMap.put(flag, model);
//				break;
//			}
//		}				
	}	
	
	
	
	/**
	 * ����һ����ʶ
	 * @Description: <TODO>
	 * @return void
	 * @throws
	 */
	public static void  setJSON(String flag,String json){		
		long date=new  Date().getTime();			
		if (userTokenMap.containsKey(flag)) {				
//			while(true){
//				synchronized (userTokenMap) {		
					userTokenMap.get(flag).json=json;
//					break;
				}
//			}				
//		}
	}	
	
	
	
	
	/**
	 * �Ƿ��з���ֵ
	 * @Description: <TODO>
	 * @return Boolean
	 * @throws
	 */
	public static Boolean validateFlag(String flag){		
			return userTokenMap.containsKey(flag)&&userTokenMap.get(flag).json!=null;
	}
		
	
	/**
	 * �õ�����ֵ����ע��
	 * @Description: <TODO>
	 * @return String
	 * @throws
	 */
	public static String getTokenMap(String flag){
			if (userTokenMap.containsKey(flag)&&userTokenMap.get(flag).json!=null) {				
//				while(true){
//					synchronized (userTokenMap) { 
						return userTokenMap.remove(flag).json;
//					}	
//				}								
			}else {
				return null;
			}
		
	}
	
	
	
	
	
	
	
}
