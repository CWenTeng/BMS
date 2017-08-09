package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java1234.model.People;
import com.java1234.util.StringUtil;


/**
 * ΩË‘ƒª·‘±Dao¿‡
 * @author s1841
 *
 */
public class PeopleDao {

	public int add(Connection con,People people)throws Exception{
		String sql="insert into t_people values(?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, people.getId());
		pstmt.setString(2, people.getPeopleName());
		pstmt.setInt(3, people.getPeopleAge());
		pstmt.setString(4, people.getPeopleSex());
		pstmt.setString(5, people.getPeopleBranch());
		
		return pstmt.executeUpdate();
	}

	public ResultSet list(Connection con, People people) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select * from t_people");
		if(StringUtil.isNotEmpty(people.getId())){
			sb.append(" and id like '%"+people.getId()+"%'");
		}
		if(StringUtil.isNotEmpty(people.getPeopleName())){
			sb.append(" and PeopleName like '%"+people.getPeopleName()+"%'");
		}

		if(StringUtil.isNotEmpty(people.getPeopleBranch())){
			sb.append(" and PeopleBranch like '%"+people.getPeopleBranch()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
