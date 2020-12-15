package com.spring.service;

import java.util.List;

import com.spring.entity.Company;
import com.spring.entity.Composdetail;
import com.spring.entity.Major;
import com.spring.entity.Position;
import com.spring.entity.Student;

public interface IStudentService {
	public List<Student> getAllStudent();
	
	public List<Major> getAllMajor();
	
	public int insertStu(Student student);
	
	public List<Company> getAllCompany();
	
	public List<Position> getAllPosition();
	
	public List<Student> getAllStudentBySearch(Student student);
	
	public int delStudent(int sid);
	
	public int updStudent(Student student);
	
	public List<Company> getAllNum();
	
	public List<Company> getCompanyDetail();
	
	public List<Composdetail> getComposdetailBycid(int cid);
	
	public List<Position> getPosMajorByChart(Position position);
	
	public Student getStuLogin(Student student);
	
	public List<Composdetail> getPosDetailByCid(int cid);
	
	public Company getComDetailByCid(int cid);

	public boolean saveChoosePos(Student stu);

	public boolean modifyChoosePos(Student stu);
}
