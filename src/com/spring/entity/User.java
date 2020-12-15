package com.spring.entity;

public class User {
	private int id;
	private String name;
	private String pwd;
	private int u_aid;
	private Account account;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String pwd, int u_aid) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.u_aid = u_aid;
	}
	
	public int getU_aid() {
		return u_aid;
	}
	public void setU_aid(int u_aid) {
		this.u_aid = u_aid;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
}
