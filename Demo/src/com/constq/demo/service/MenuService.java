package com.constq.demo.service;

import java.util.List;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.Menu;

public interface MenuService {
	public Integer getTotal();

	public List<Menu> findAllMenu();

	public List<Menu> findAllMenuByPage(Page page);

	public void addMenu(Menu Menu);

	public void updateMenu(Menu Menu);

	public void deleteMenuById(String id);
}
