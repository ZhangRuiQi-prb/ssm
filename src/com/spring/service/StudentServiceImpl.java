package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.entity.Company;
import com.spring.entity.Composdetail;
import com.spring.entity.Major;
import com.spring.entity.Position;
import com.spring.entity.Scores;
import com.spring.entity.Student;
import com.spring.mapper.IStudentMapper;
@Component("stuService")
public class StudentServiceImpl implements IStudentService {
	private IStudentMapper studentMapper;
	@Autowired
	public void setStudentMapper(@Qualifier("stuMapper")IStudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		
		return studentMapper.selectAllStudent();
	}
	@Override
	public List<Major> getAllMajor() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllMajor();
	}
	@Override
	public int insertStu(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.insertStudent(student);
	}
	@Override
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllCompany();
	}
	@Override
	public List<Position> getAllPosition() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllPosition();
	}
	@Override
	public List<Student> getAllStudentBySearch(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.selectAllStudentBySearch(student);
	}
	@Override
	public int delStudent(int sid) {
		// TODO Auto-generated method stub
		return studentMapper.deleteStudent(sid);
	}
	@Override
	public int updStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateStudent(student);
	}
	@Override
	public List<Company> getAllNum() {
		// TODO Auto-generated method stub
		return studentMapper.selectAllNum();
	}
	@Override
	public List<Company> getCompanyDetail() {
		// TODO Auto-generated method stub
		return studentMapper.selectCompanyDetail();
	}
	@Override
	public List<Composdetail> getComposdetailBycid(int cid) {
		// TODO Auto-generated method stub
		return studentMapper.selectComposdetailBycid(cid);
	}
	@Override
	public List<Position> getPosMajorByChart(Position position) {
		// TODO Auto-generated method stub
		return studentMapper.SelectPosMajorByChart(position);
	}
	@Override
	public Student getStuLogin(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.SelectStuLogin(student);
	}
	@Override
	public List<Composdetail> getPosDetailByCid(int cid) {
		// TODO Auto-generated method stub
		return studentMapper.selectPosDetailByCid(cid);
	}
	@Override
	public Company getComDetailByCid(int cid) {
		// TODO Auto-generated method stub
		return studentMapper.selectComDetailByCid(cid);
	}
	@Override
	public boolean saveChoosePos(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.insertChoosePos(stu)>0;
	}
	@Override
	public boolean modifyChoosePos(Student stu) {
		// TODO Auto-generated method stub
		return studentMapper.updateChoosePos(stu)>0;
	}

}
