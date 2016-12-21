package com.constq.demo.mapper;

import java.util.List;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.User;

public interface UserMapper {

	public List<User> findAllUser();

	public List<User> findAllUserByPage(Page page);

	public Integer getTotal();

}
