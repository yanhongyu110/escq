package com.jero.esc.common.interceptor;

public class SqlServerDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		pagingSelect.append("select * from (");
		pagingSelect.append(" select row_number()over(order by tempcolumn)temprownumber,* from ");
		pagingSelect.append( "(select top ").append(limit).append(" tempcolumn=0, ");
		//删除开头的select
		pagingSelect.append(sql.substring(6));
		pagingSelect.append(" )t )tt where temprownumber > ").append(offset);

		return pagingSelect.toString();
	}

}
