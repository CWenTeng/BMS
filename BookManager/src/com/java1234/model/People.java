package com.java1234.model;

/**
 * ��Աʵ��
 * @author s1841
 *
 */
public class People {
	private String id;					//���
	private String peopleName;		//����
	private int peopleAge;			//����
	private String peopleSex;		//�Ա�
	private String peopleBranch;	//����
	
	
	
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
