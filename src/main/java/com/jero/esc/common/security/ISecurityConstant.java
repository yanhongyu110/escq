package com.jero.esc.common.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public interface ISecurityConstant {
	/**
	 * 超级管理员名称
	 */
	public static final String SUPER_ADMIN_NAME = "admin";
	/**
	 * all operations value in operation field of Authority table
	 */
	public static final String AUTHORITY_ALL_OPERATIONS = "all";

	/**
	 * super authority
	 */
	public static final String AUTHORITY_SUPER_POWER = "super_authority";

	public static final List<SimpleGrantedAuthority> LOGIN_USER_BASIC_AUTHORITY = new ArrayList<SimpleGrantedAuthority>() {
		private static final long serialVersionUID = -5060542075950351987L;
		{
			
		}
	};

}
