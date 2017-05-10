package com.hl.JDBCC3P0Utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JDBCC3P0Utils {
	private static ComboPooledDataSource data_source=new ComboPooledDataSource();
	public static DataSource getDataSource(){
		return data_source;
	}
}
