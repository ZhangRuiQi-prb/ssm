package com.spring.entity;

public class Composdetail {
	private int cpid,cp_cid,cp_pid,cpnums,nums;
	private String cprequire, cpsalary;
	private Position position;
	private Company company;
	public Composdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public int getCpid() {
		return cpid;
	}
	public void setCpid(int cpid) {
		this.cpid = cpid;
	}
	public int getCp_cid() {
		return cp_cid;
	}
	public void setCp_cid(int cp_cid) {
		this.cp_cid = cp_cid;
	}
	public int getCp_pid() {
		return cp_pid;
	}
	public void setCp_pid(int cp_pid) {
		this.cp_pid = cp_pid;
	}
	public int getCpnums() {
		return cpnums;
	}
	public void setCpnums(int cpnums) {
		this.cpnums = cpnums;
	}
	public String getCprequire() {
		return cprequire;
	}
	public void setCprequire(String cprequire) {
		this.cprequire = cprequire;
	}
	public String getCpsalary() {
		return cpsalary;
	}
	public void setCpsalary(String cpsalary) {
		this.cpsalary = cpsalary;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
