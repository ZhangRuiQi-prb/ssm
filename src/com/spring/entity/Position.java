package com.spring.entity;

public class Position {
	private int pid, nums;
	private String pname, ptime, pimg, ptest, pmname,pinfo;
	private Company company;//只是负责赋值的公司实体类对象的创建，赋值#{companys.cid},返回的数据赋值setter与其也无关
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public String getPmname() {
		return pmname;
	}

	public void setPmname(String pmname) {
		this.pmname = pmname;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getPtest() {
		return ptest;
	}
	public void setPtest(String ptest) {
		this.ptest = ptest;
	}
	
}
