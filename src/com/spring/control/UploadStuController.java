package com.spring.control;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.entity.Student;
import com.spring.service.IStudentService;

@Controller
@Scope("prototype")
@RequestMapping("files")
public class UploadStuController {
	private IStudentService studentService;
	@Autowired
	public void setStudentService(@Qualifier("stuService")IStudentService studentService) {
		this.studentService = studentService;
	}
	
	/**
	 * 利用MultipartFile对象做上传操作，但是该对象操作有弊端的
	 * 第一推进上传，但是不能一个二进制文件上传两个path，第二该对象也不推荐用该对象download，
	 * 第三受限于UI框架，layui or bootstrap 上传的程序逻辑不同的
	 * @param file1   <input type="file" name="file1" 也就是同步机制 input的name属性是相当重要的
	 * @param student 还有学生其他信息insert
	 * @param request 获取上传路径的，当前也就是Tomcat发布的路径，和eclipse无关，其次注意Tomcat如果关闭
	 *  那么上传的二进制文件就消失了
	 * @return
	 */
	
	@RequestMapping("/upload")
	public String insert(@RequestParam("file1") MultipartFile file1,Student stu,
			HttpServletRequest request) {
		//0-67-hello方式-456
		System.out.println(stu.getS_mid()+"-"+stu.getSage()+"-"+stu.getSname());
		//获取二进制文件名
		String filename=file1.getOriginalFilename();
		System.out.println(filename+" :name");
		stu.setSimg(filename);
		//获取上传Tomcat发布路径
		String pathRoot=request.getRealPath("/images/photos");
		//eclipes
//		String path="D:/eclipse-jee/spring/workspace/Day1105_SSM/WebContent/images/photos";
		//设置文件名
	    filename=pathRoot+"/"+filename;
//	    String filename1=path+"/"+filename;
	    System.out.println(filename+" :path");
	    // 文件对象
	    File dest=new File(filename);
	    // 判断路径是否存在，如果不存在则创建
	    if(!dest.getParentFile().exists()) {
	    	dest.getParentFile().mkdirs();
	    }
	    try {
	    	// 保存到服务器中
			file1.transferTo(dest);
//		    File file1=new File(filename1);	
		    //File has already been moved - cannot be transferred again
		    //如果想上传第二个路径，那么IO完成
//		    file2.transferTo(file1);
		    //insert mysql，封装Student对象
			if(studentService.insertStu(stu)>0) {
				return "redirect:/dynamic_table.html?us=ok";	
			}else {
				return "redirect:/dynamic_table.html?us=error";	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/dynamic_table.html?us=error";
		} 
		
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("file2") MultipartFile file2,Student stu,
			HttpServletRequest request) {
		//0-67-hello方式-456
		System.out.println(stu.getS_mid()+"-"+stu.getSage()+"-"+stu.getSname());
		//获取二进制文件名
		String filename=file2.getOriginalFilename();
		System.out.println(filename+" :name");
		stu.setSimg(filename);
		//获取上传Tomcat发布路径
		String pathRoot=request.getRealPath("/images/photos");
		//eclipes
//		String path="D:/eclipse-jee/spring/workspace/Day1105_SSM/WebContent/images/photos";
		//设置文件名
	    filename=pathRoot+"/"+filename;
//	    String filename1=path+"/"+filename;
	    System.out.println(filename+" :path");
	    // 文件对象
	    File dest=new File(filename);
	    // 判断路径是否存在，如果不存在则创建
	    if(!dest.getParentFile().exists()) {
	    	dest.getParentFile().mkdirs();
	    }
	    try {
	    	// 保存到服务器中
			file2.transferTo(dest);
//		    File file1=new File(filename1);	
		    //File has already been moved - cannot be transferred again
		    //如果想上传第二个路径，那么IO完成
//		    file2.transferTo(file1);
		    //insert mysql，封装Student对象
			if(studentService.updStudent(stu)>0) {
				return "redirect:/dynamic_table.html?us=ok";	
			}else {
				return "redirect:/dynamic_table.html?us=error";	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/dynamic_table.html?us=error";
		} 
		
	}
}
