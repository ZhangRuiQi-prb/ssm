package com.spring.entity;

public class Student {
	private int sid=-1, sage, s_mid=-1, s_cid=-1, s_pid=-1,spwd, scid=0;
	private String sname, sdate, simg, ssex;
	private Major major;
	private Company company;
	private Position position;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getSpwd() {
		return spwd;
	}

	public void setSpwd(int spwd) {
		this.spwd = spwd;
	}

	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public int getS_cid() {
		return s_cid;
	}

	public void setS_cid(int s_cid) {
		this.s_cid = s_cid;
	}

	public int getS_pid() {
		return s_pid;
	}

	public void setS_pid(int s_pid) {
		this.s_pid = s_pid;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public int getS_mid() {
		return s_mid;
	}
	public void setS_mid(int s_mid) {
		this.s_mid = s_mid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
}
