package com.constq.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constq.demo.mapper.UserMapper;
import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.User;
import com.constq.demo.service.UserService;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserMapper userMapper;

	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}

	public List<User> findAllUserByPage(Page page) {
		// TODO Auto-generated method stub
		return userMapper.findAllUserByPage(page);
	}

	public Integer getTotal() {
		// TODO Auto-generated method stub
		return userMapper.getTotal();
	}
	
	
}
