package com.constq.demo.service;

import java.util.List;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.User;

public interface UserService {
	public Integer getTotal();

	public List<User> findAllUser();

	public List<User> findAllUserByPage(Page page);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUserById(String id);
}
