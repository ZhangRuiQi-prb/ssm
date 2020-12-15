package com.spring.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.entity.Company;
import com.spring.entity.Composdetail;
import com.spring.entity.Major;
import com.spring.entity.Position;
import com.spring.entity.Student;

@Component("stuMapper")
public interface IStudentMapper {
	public List<Student> selectAllStudent();
	
	public List<Major> selectAllMajor();
	
	public int insertStudent(Student student);
	
	public List<Company> selectAllCompany();
	
	public List<Position> selectAllPosition();
	
	public List<Student> selectAllStudentBySearch(Student student);
	
	public int deleteStudent(int sid);
	
	public int updateStudent(Student student);
	
	public List<Company> selectAllNum();
	
	public List<Company> selectCompanyDetail();
	
	public List<Composdetail> selectComposdetailBycid(int cid);
	
	public List<Position> SelectPosMajorByChart(Position position);
	
	public Student SelectStuLogin(Student student);
	
	public List<Composdetail> selectPosDetailByCid(int cid);
	
	public Company selectComDetailByCid(int cid);

	public int insertChoosePos(Student stu);

	public int updateChoosePos(Student stu);
}
