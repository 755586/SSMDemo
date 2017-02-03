package com.constq.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/west/menu")
public class MenuController {

	@RequestMapping(value = "")
	public String user(HttpServletRequest request) {
		return "system/west/menu";
	}

	@RequestMapping(value = "", params = { "action=list" })
	@ResponseBody
	public List<Map<String, Object>> list(HttpServletRequest request) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list3 = new ArrayList<Map<String, Object>>();
		/*首页*/
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("id", "0");
		map0.put("text", "首页");
		map0.put("url", "system/center/index");
		list.add(map0);
		
		/*用户*/
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", "1");
		map1.put("text", "用户管理");
		map1.put("url", "system/center/user");
		list.add(map1);
		
		/*词汇*/
		Map<String, Object> word = new HashMap<String, Object>();
		word.put("id", "4");
		word.put("text", "词汇管理");
		/*词汇-词汇统计*/
		Map<String, Object> word1 = new HashMap<String, Object>();
		word1.put("id", "5");
		word1.put("text", "词汇统计");
		word1.put("url", "system/center/word/chart");
		list3.add(word1);
		/*词汇-词汇编辑*/
		Map<String, Object> word2 = new HashMap<String, Object>();
		word2.put("id", "5");
		word2.put("text", "词汇编辑");
		word2.put("url", "system/center/word/edit");
		list3.add(word2);
		word.put("children", list3);
		list.add(word);
		/*参数*/
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", "2");
		map2.put("text", "参数管理");
		/*参数 -功能参数*/
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("id", "3");
		map3.put("text", "功能参数");
		list2.add(map3);
		map2.put("children", list2);
		list.add(map2);
		return list;
		/*
		 * data: [{ text: 'Item1', state: 'closed', children: [{ text: 'Item11'
		 * },{ text: 'Item12' }] },{ text: 'Item2' }]
		 */
	}

	// @RequestMapping(value="",params={"action=update"})
	// @ResponseBody
	// public User update(HttpServletRequest request,String id,String
	// name,String password){
	// User user = new User(id, name, password);
	// userService.updateUser(user);
	// return user;
	// }
	//
	// @RequestMapping(value="",params={"action=delete"})
	// @ResponseBody
	// public Map<String, Object> delete(HttpServletRequest request,String id){
	// Map<String, Object> map = new HashMap<String, Object>();
	// userService.deleteUserById(id);
	// map.put("success", true);
	// return map;
	// }
	//
	// @RequestMapping(value="",params={"action=add"})
	// @ResponseBody
	// public User add(HttpServletRequest request,String name,String password){
	// User user = new User();
	// user.setName(name);
	// user.setPassword(password);
	// userService.addUser(user);
	// return user;
	// }
}
