package com.constq.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constq.demo.pojo.Factory;
import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.User;
import com.constq.demo.service.UserService;

@Controller
@RequestMapping("/system/menu")
public class MenuController {
	
	
	@RequestMapping(value="")
	public String user(HttpServletRequest request) {
		return "system/menu";
	}
	
	@RequestMapping(value="",params={"action=list"})
	@ResponseBody
	public Object list(HttpServletRequest request,int page,int rows){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1");
		map.put("text", "用户管理");
		return map;
	}
	
//	@RequestMapping(value="",params={"action=update"})
//	@ResponseBody
//	public User update(HttpServletRequest request,String id,String name,String password){
//		User user = new User(id, name, password);
//		userService.updateUser(user);
//		return user;
//	}
//	
//	@RequestMapping(value="",params={"action=delete"})
//	@ResponseBody
//	public Map<String, Object> delete(HttpServletRequest request,String id){
//		Map<String, Object> map = new HashMap<String, Object>();
//		userService.deleteUserById(id);
//		map.put("success", true);
//		return map;
//	}
//	
//	@RequestMapping(value="",params={"action=add"})
//	@ResponseBody
//	public User add(HttpServletRequest request,String name,String password){
//		User user = new User();
//		user.setName(name);
//		user.setPassword(password);
//		userService.addUser(user);
//		return user;
//	}
}
