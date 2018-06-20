package com.java1234.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author s1841
 *
 */
public class DbUtil {

	//数据库连接地址
	private String dbUrl="jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong";
	//用户名
	private String dbUserName="root";
	//密码
	private String dbPassword="root";
	//mysql驱动包名
	private String jdbcName="com.mysql.cj.jdbc.Driver";

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
