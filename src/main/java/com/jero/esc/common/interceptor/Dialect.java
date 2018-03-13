package com.jero.esc.common.interceptor;

public abstract class Dialect {

	public static enum Type {
		MYSQL, SQLSERVER, ORACLE
	}

	public abstract String getLimitString(String sql, int offset, int limit);
}
