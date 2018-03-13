package com.jero.esc.common.utils.random;

import java.util.Random;

public class FastRandom {

	
	public static void main(String[] args) {
		System.out.println();
	}
	
	public static String getRandom(int length){
		String mo="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM1234567890";		
		char[] c=mo.toCharArray();
		StringBuffer re=new StringBuffer();
		Random random=new  Random();		
		for (int i = 0; i < length; i++) {
			re.append(c[random.nextInt(c.length)]);
		}
		return re.toString();										
	}
	
	
}
