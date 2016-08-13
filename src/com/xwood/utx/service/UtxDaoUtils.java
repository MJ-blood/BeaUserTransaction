package com.xwood.utx.service;

import org.springframework.jdbc.core.JdbcTemplate;
import com.xwood.utx.util.SpringBeans;

public class UtxDaoUtils {
	private static JdbcTemplate dbs=(JdbcTemplate)SpringBeans.getBean("jdbcTemplate");
	private static JdbcTemplate dbs2=(JdbcTemplate)SpringBeans.getBean("jdbcTemplate2");
	public static void delTab1(){
			String sql = "delete from tab_1 where id = ?";
			Object[] values = new Object[] { 1 };
			dbs.update(sql, values);
	}
	public static void delTab2(){
		String sql = "delete from tab_2 where id = ?";
		Object[] values = new Object[] { 2 };
		dbs2.update(sql, values);
	}
}
