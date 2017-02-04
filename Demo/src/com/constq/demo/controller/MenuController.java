package com.constq.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constq.demo.pojo.Menu;
import com.constq.demo.service.MenuService;
import com.constq.demo.service.UserService;

@Controller
@RequestMapping("/system/west/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "")
	public String user(HttpServletRequest request) {
		return "system/west/menu";
	}

	@RequestMapping(value = "", params = { "action=list" })
	@ResponseBody
	public List<Map<String, Object>> list(HttpServletRequest request) {
		List<Menu> menus = menuService.findAllMenu();
		List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
		for(Menu m:menus){
			String pId = m.getpId();
			String url = m.getUrl();
			if(pId==null||pId.equals("")){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", m.getId());
				map.put("text", m.getName());
				map.put("url", m.getUrl().substring(1));
				List<Map<String, Object>> menuList2 = new ArrayList<Map<String, Object>>();//二级菜单
				for(Menu m2:menus){
					if(m2.getpId()!=null&&m2.getpId().equals(url)){
						Map<String, Object> map2 = new HashMap<String, Object>();
						map2.put("id", m2.getId());
						map2.put("text", m2.getName());
						map2.put("url", m2.getUrl().substring(1));
						menuList2.add(map2);
					}
				}
				map.put("children", menuList2);
				menuList.add(map);
			}
		}
		return menuList;
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
