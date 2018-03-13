package com.jero.esc.common.utils;

public class MyStringUtil {
	
	public static int getWordCount(String s){
        s = s.replaceAll("[^\\x00-\\xff]", "**");
        int length = s.length();
        return length;
    }
}
