package com.spring.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.entity.Account;
import com.spring.entity.User;
import com.spring.mapper.IUserMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	private IUserMapper userMapper;
	@Autowired
	public void setUserMapper(@Qualifier("userMapper")IUserMapper userMapper) {
		this.userMapper = userMapper;
	}
	//user/list.action
	@RequestMapping("/list")
	@ResponseBody
	public List<Map<String, Object>> GetAllUser(){
		List<User> list = userMapper.GetAllUser();
		System.out.println(list.size()+" size");
		List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		for ( User user : list) {
			map = new HashMap<String, Object>();
			map.put("uid", user.getId());
			map.put("uname", user.getName());
			map.put("upwd", user.getPwd());
			map.put("aid", user.getAccount().getId());
			map.put("atype", user.getAccount().getType());
			list1.add(map);
		}
		return list1;
	}
	
	@RequestMapping("/account")
	@ResponseBody
	public List<Account> GetAllAccount(){
		List<Account> list = userMapper.GetAllAccount();
		System.out.println(list.size()+" size");
		
		return list;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public int insetUser(User user) {
		System.out.println(user.getId()+user.getName());
		return userMapper.insertUser(user);
	}
}
