package com.constq.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.User;
import com.constq.demo.service.UserService;

@Controller
@RequestMapping("/system/user")
public class UserManagerController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="")
	public String user(HttpServletRequest request) {
		return "system/user";
	}
	
	@RequestMapping(value="",params={"action=list"})
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request,int page,int rows){
		Integer total = userService.getTotal();
		int start = (page-1)*rows+1;
		int end = (page)*rows;
		List<User> users = userService.findAllUserByPage(new Page(start,end));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", users);
		return map ;
	}
	
	@RequestMapping(value="",params={"action=update"})
	@ResponseBody
	public void update(HttpServletRequest request,String id,String name,String password){
		User user = new User(id, name, password);
		System.out.println(user);
		userService.updateUser(user);
		System.out.println("update");
	}
}
