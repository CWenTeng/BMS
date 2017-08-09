package com.java1234.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author s1841
 *
 */
public class DbUtil {

	private String dbUrl="jdbc:mysql://localhost:3306/db_book";	//
	private String dbUserName="root";						//用户名
	private String dbPassword="root";						//密码
	private String jdbcName="com.mysql.jdbc.Driver";		//驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args){
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败!");
		}
	}
}
