package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.Borrow;


public class BorrowDao {

	/**
	 * 借阅信息添加
	 * @param con
	 * @param borrow
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Borrow borrow) throws Exception{
		String sql="insert into t_borrow values("+borrow.getPeopleId()+","+borrow.getBookId()+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
//		pstmt.setString(0, borrow.getPeopleId());
//		pstmt.setString(1, borrow.getBookId());
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 点击查询对应借阅图书
	 * @param con
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,String p) throws Exception{
		StringBuffer sb=new StringBuffer("SELECT * FROM t_book b,t_borrow br,t_bookType bt WHERE br.peopleId=? AND br.bookId=b.id AND b.bookTypeId=bt.id");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, p);
		return pstmt.executeQuery();
	}
	
	
	/**
	 * 图书归还
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int back(Connection con,String id) throws Exception{
		String sql="DELETE t_borrow FROM t_book,t_borrow WHERE id=? AND bookId=id";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书丢失
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int lose(Connection con,String id){
		String sql="DELETE t_borrow,t_book FROM t_book,t_borrow WHERE id=? AND bookId=id";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		
	}
	
	
}