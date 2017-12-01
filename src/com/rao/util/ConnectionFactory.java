package com.rao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;




public class ConnectionFactory {

	private static String dbDriver;
	private static String dbUrl;
	private static String dbUser;
	private static String dbPassWord;
	
	private static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn;
	static{
		Properties prop = new Properties();
		try{
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		}catch(Exception e){
			
		}
		dbDriver = prop.getProperty("dbDriver");
		dbUrl = prop.getProperty("dbUrl");
		dbUser = prop.getProperty("dbUser");
		dbPassWord = prop.getProperty("dbPassWord");
		
	}
	
	private ConnectionFactory(){
		
	}
	public static ConnectionFactory getInstance(){
		return factory;
	}
	
	public Connection makeConnetion(){
		try{
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassWord);
		}catch (Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}

