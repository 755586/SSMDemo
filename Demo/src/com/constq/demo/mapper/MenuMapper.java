package com.constq.demo.mapper;

import java.util.List;

import com.constq.demo.pojo.Page;
import com.constq.demo.pojo.Menu;

public interface MenuMapper {

	public List<Menu> findAllMenu();

	public List<Menu> findAllMenuByPage(Page page);

	public Integer getTotal();

	public void addMenu(Menu Menu);

	public void updateMenu(Menu Menu);

	public void deleteMenuById(String id);
}
