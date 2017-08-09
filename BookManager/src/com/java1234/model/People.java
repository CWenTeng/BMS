package com.java1234.model;

/**
 * 人员实体
 * @author s1841
 *
 */
public class People {
	private String id;					//编号
	private String peopleName;		//姓名
	private int peopleAge;			//年龄
	private String peopleSex;		//性别
	private String peopleBranch;	//部门
	
	
	
	public People(String id, String peopleName, String peopleBranch) {
		super();
		this.id = id;
		this.peopleName = peopleName;
		this.peopleBranch = peopleBranch;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPeopleName() {
		return peopleName;
	}
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	public int getPeopleAge() {
		return peopleAge;
	}
	public void setPeopleAge(int peopleAge) {
		this.peopleAge = peopleAge;
	}
	public String getPeopleSex() {
		return peopleSex;
	}
	public void setPeopleSex(String peopleSex) {
		this.peopleSex = peopleSex;
	}
	public String getPeopleBranch() {
		return peopleBranch;
	}
	public void setPeopleBranch(String peopleBranch) {
		this.peopleBranch = peopleBranch;
	}

	public People(String id, String peopleName, int peopleAge, String peopleSex, String peopleBranch) {
		super();
		this.id = id;
		this.peopleName = peopleName;
		this.peopleAge = peopleAge;
		this.peopleSex = peopleSex;
		this.peopleBranch = peopleBranch;
	}
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}
