package com.spring.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.entity.Company;
import com.spring.entity.Composdetail;
import com.spring.entity.Major;
import com.spring.entity.Position;
import com.spring.entity.Student;
import com.spring.entity.User;
import com.spring.service.IStudentService;

@Controller
@RequestMapping("/stu")
public class StudentController {
	private IStudentService studentService;
	@Autowired
	public void setStudentService(@Qualifier("stuService")IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("/ChoosePos")
	@ResponseBody
	public String getChoosePos(Student stu){
		System.out.println(stu.getPosition().getPid()+","+stu.getSid()+","+
				stu.getCompany().getCid()+","+stu.getScid());
		String msg=null;
		if(stu.getScid()==0) {
			//insert
			if(studentService.saveChoosePos(stu)) {
				msg="ok";
			}else {
				msg="error";
			}
		}else {
			//update
			if(studentService.modifyChoosePos(stu)) {
				msg="ok";
			}else {
				msg="error";
			}
		}
		return msg;
	}
	
	@RequestMapping("/posDetail")
	@ResponseBody
	public Map<String, Object> getPosDetail(int cid){
		System.out.println("cid"+cid);
		List<Composdetail> list = studentService.getPosDetailByCid(cid);
		System.out.println("size:"+list.size());
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for ( Composdetail composdetail: list) {
			map = new HashMap<String, Object>();
			map.put("cpid", composdetail.getCpid());
			map.put("pinfo", composdetail.getPosition().getPinfo());
			map.put("cpnums", composdetail.getCpnums());
			map.put("cpsalary", composdetail.getCpsalary());
			map.put("pname", composdetail.getPosition().getPname());
			map.put("pid", composdetail.getPosition().getPid());
			map.put("pimg", composdetail.getPosition().getPimg());
			map.put("nums", composdetail.getNums());
			list1.add(map);
		}
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("clist", list1);
		
		//company detail
        Company company=studentService.getComDetailByCid(cid);
        map=new HashMap<String, Object>();
        map.put("cid", company.getCid());
        map.put("cname", company.getCname());
        map.put("cimg", company.getCimg());
        map.put("cztxt", company.getCztxt());
        List<String> ls=new ArrayList<String>();
        if(company.getCzimgs()==null) {
        	company.setCzimgs("");
        }
        String[] img=company.getCzimgs().split(",");
        for (String string : img) {
			ls.add(string);
		}
        map.put("czimgs", ls);
        map.put("czvideo", company.getCzvideo());
        map.put("czchose", company.getCzchose());
        
        map1.put("companydetail",map);
		return map1;
	}
	
	@RequestMapping("/stuLogin")
	@ResponseBody
	public Map<String, Object> stuLogin(Student stu){
		System.out.println(stu.getSname()+" / "+stu.getSpwd());
		Student student = studentService.getStuLogin(stu);
		Map<String, Object> map=new HashMap<String, Object>();
        map.put("sid",student.getSid());
        map.put("sname",student.getSname());
        map.put("mname",student.getMajor().getMname());
        map.put("simg",student.getSimg());
        map.put("scid",student.getScid());
        System.out.println("scid:"+student.getScid());
		return map;	
	}
	
	@RequestMapping("/majorChart")
	@ResponseBody
	public Map<String, Object> getmajorChart(int ccid,int ppid){
		System.out.println(ccid+","+ppid);
		Position position = new Position();
		position.setPid(ppid);
		Company company = new Company();
		company.setCid(ccid);
		position.setCompany(company);
		List<Position> list = studentService.getPosMajorByChart(position);
		System.out.println(list.size()+"size");
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<List<Object>> list1 = new ArrayList<List<Object>>();
		String pname = null;
		for (Position position2 : list) {
			List<Object> list2=new LinkedList<Object>();
			if(pname==null) {
				pname = position2.getPname();
			}
			list2.add(position2.getPmname());
			list2.add(position2.getNums());
			list1.add(list2);
		}
		map1.put("lists", list1);
		map1.put("title",pname+"实习学生数据比例");
		map1.put("name","实习学生数量");
		return map1;
	}
	
	@RequestMapping("/compDetail2")
	@ResponseBody
	public List<Map<String, Object>> getCompDetail2(int ccid){
		System.out.println("ccid"+ccid);
		List<Composdetail> list = studentService.getComposdetailBycid(ccid);
		System.out.println("size:"+list.size());
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for ( Composdetail composdetail: list) {
			map = new HashMap<String, Object>();
			map.put("cpid", composdetail.getCpid());
			map.put("cprequire", composdetail.getCprequire());
			map.put("cpnums", composdetail.getCpnums());
			map.put("cpsalary", composdetail.getCpsalary());
			map.put("pname", composdetail.getPosition().getPname());
			map.put("pid", composdetail.getPosition().getPid());
			map.put("pimg", composdetail.getPosition().getPimg());
			map.put("nums", composdetail.getNums());
			list1.add(map);
		}
		return list1;
	}
	
	@RequestMapping("/compDetail")
	@ResponseBody
	public List<Map<String, Object>> getCompDetail(){
		List<Company> list = studentService.getCompanyDetail();
		System.out.println("size:"+list.size());
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for ( Company company : list) {
			map = new HashMap<String, Object>();
			map.put("cid", company.getCid());
			map.put("cname", company.getCname());
			map.put("ctime", company.getCtime().substring(0, 11));
			map.put("cimg", company.getCimg());
			map.put("cpos", company.getPos());
			map.put("cnum", company.getNum());
			map.put("cmoney", company.getCmoney());
			map.put("czhuc", company.getCzhuc());
			map.put("allnums", company.getAllnums());
			list1.add(map);
		}
		return list1;
	}
	
	
	@RequestMapping("/allnum")
	@ResponseBody
	public Map<String, Object> getComStuNum(){
		List<Company> list = studentService.getAllNum();
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<String> str = new ArrayList<String>();
		List<Integer> num = new ArrayList<Integer>();
		map1.put("text", "学生选企业图");
		map1.put("name", "学生人数");
		
		for (Company company : list) {
			str.add(company.getCname());
			num.add(company.getNum());
		}
		
		map1.put("categories", str);
		map1.put("data", num);
		return map1;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public List<Map<String, Object>> deleteStu(int sid) {
		System.out.println("要删除的id："+sid);
		List<Map<String, Object>> list1 = null;
		if(studentService.delStudent(sid)>0) {
			
			List<Student> list = studentService.getAllStudent();
			System.out.println("size:"+list.size());
			list1 = new ArrayList<Map<String,Object>>();
			Map<String, Object> map = null;
			for ( Student student : list) {
				map = new HashMap<String, Object>();
				map.put("sid", student.getSid());
				map.put("sname", student.getSname());
				map.put("sage", student.getSage());
				map.put("sdate", student.getSdate());
				map.put("simg", student.getSimg());
				map.put("ssex", student.getSsex());
				map.put("s_mid", student.getS_mid());
				map.put("mname", student.getMajor().getMname());
				map.put("pname", student.getPosition().getPname());
				map.put("cname", student.getCompany().getCname());
				list1.add(map);
			}
		}
		return list1;
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public List<Map<String, Object>> searchStu(Student stu){
		stu.setSname("%"+stu.getSname().trim()+"%");
		System.out.println("学号："+stu.getSid()+",姓名："+stu.getSname()+",专业："+stu.getS_mid()
			+",公司："+stu.getS_cid()+",职位："+stu.getS_pid());
		
		List<Student> list = studentService.getAllStudentBySearch(stu);
		System.out.println("size:"+list.size());
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for ( Student student : list) {
			map = new HashMap<String, Object>();
			map.put("sid", student.getSid());
			map.put("sname", student.getSname());
			map.put("sage", student.getSage());
			map.put("sdate", student.getSdate());
			map.put("simg", student.getSimg());
			map.put("ssex", student.getSsex());
			map.put("s_mid", student.getS_mid());
			map.put("mname", student.getMajor().getMname());
			map.put("pid", student.getPosition().getPid());
			map.put("pname", student.getPosition().getPname());
			map.put("cid", student.getCompany().getCid());
			map.put("cname", student.getCompany().getCname());
			list1.add(map);
		}
		return list1;
	}
	
	@RequestMapping("/allStu")
	@ResponseBody
	public List<Map<String, Object>> getAllStu(){
		List<Student> list = studentService.getAllStudent();
		System.out.println("size:"+list.size());
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for ( Student student : list) {
			map = new HashMap<String, Object>();
			map.put("sid", student.getSid());
			map.put("sname", student.getSname());
			map.put("sage", student.getSage());
			map.put("sdate", student.getSdate());
			map.put("simg", student.getSimg());
			map.put("ssex", student.getSsex());
			map.put("s_mid", student.getS_mid());
			map.put("mname", student.getMajor().getMname());
			map.put("pid", student.getPosition().getPid());
			map.put("pname", student.getPosition().getPname());
			map.put("cid", student.getCompany().getCid());
			map.put("cname", student.getCompany().getCname());
			list1.add(map);
		}
		return list1;
	}
	
	@RequestMapping("/allMaj")
	@ResponseBody
	public Map<String, Object> getAllMaj(){
		List<Major> majorlist = studentService.getAllMajor();
		
		List<Company> companylist = studentService.getAllCompany();
		
		List<Position> positionlist = studentService.getAllPosition();
		
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		Map<String, Object> map1 = new HashMap<String, Object>();
		for ( Major major : majorlist) {
			map = new HashMap<String, Object>();
			map.put("mid", major.getMid());
			map.put("mname", major.getMname());
			map.put("mtime", major.getMtime());
			map.put("mtest", major.getMtest());
			list1.add(map);
		}
		map1.put("major1", list1);
		

		list1 = new ArrayList<Map<String,Object>>();
		for ( Company company : companylist) {
			map = new HashMap<String, Object>();
			map.put("cid", company.getCid());
			map.put("cname", company.getCname());
			list1.add(map);
		}
		map1.put("company1", list1);
		

		list1 = new ArrayList<Map<String,Object>>();
		for ( Position position : positionlist) {
			map = new HashMap<String, Object>();
			map.put("pid", position.getPid());
			map.put("pname", position.getPname());
			list1.add(map);
		}
		map1.put("position1", list1);
		
		return map1;
	}
}
