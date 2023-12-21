package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;
	
	// input: String name, String yyyymmdd, String email, String introduce
	// ouput: void
	public void addUser(String name, String yyyymmdd, String email, String introduce) {
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	// input: x
	// ouput: User(있거나 null)
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
}
