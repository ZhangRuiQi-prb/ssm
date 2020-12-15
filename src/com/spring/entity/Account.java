package com.spring.entity;

public class Account {
	private int id;
	private String type;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + "]";
	}
	
}
