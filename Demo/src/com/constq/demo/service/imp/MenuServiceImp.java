package com.constq.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constq.demo.mapper.MenuMapper;
import com.constq.demo.mapper.MenuMapper;
import com.constq.demo.pojo.Factory;
import com.constq.demo.pojo.Menu;
import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.Menu;
import com.constq.demo.service.MenuService;

@Service
public class MenuServiceImp implements MenuService{

	@Autowired
	private MenuMapper menuMapper;

	public List<Menu> findAllMenu() {
		return menuMapper.findAllMenu();
	}

	public List<Menu> findAllMenuByPage(Page page) {
		// TODO Auto-generated method stub
		return menuMapper.findAllMenuByPage(page);
	}

	public Integer getTotal() {
		// TODO Auto-generated method stub
		return menuMapper.getTotal();
	}

	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.setId(Factory.getRandom());
		menuMapper.addMenu(menu);
	}

	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.updateMenu(menu);
	}

	public void deleteMenuById(String id) {
		// TODO Auto-generated method stub
		menuMapper.deleteMenuById(id);
	}

}
