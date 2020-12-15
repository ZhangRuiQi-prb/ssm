package com.spring.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.entity.Account;
import com.spring.entity.User;
@Component("userMapper")
public interface IUserMapper {
	public List<User> GetAllUser();
	
	public List<Account> GetAllAccount();
	
	public int insertUser(User user);
}
