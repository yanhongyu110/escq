package com.jero.esc.common.utils.wx;

public class InvalidTokenException extends Exception {
	
	public InvalidTokenException() {		
		WeiChatUtill.ERR_COUNT++;
		System.out.println("��ȡtoken����"+WeiChatUtill.ERR_COUNT+"��");
	}
	
}
