package com.sprink.api.service;

import java.util.List;

import com.sprink.api.exception.MenuItemNotFoundException;
import com.sprink.api.model.MenuItem;

public interface MenuItemService {

	public MenuItem createMenuItem(MenuItem item);
	public MenuItem updatedMenuItem(MenuItem item,int id)throws MenuItemNotFoundException;
	public List<MenuItem> getMenuItems();
	public MenuItem getMenu(int id)throws MenuItemNotFoundException;
	public void deleteMenuItem(int id)throws MenuItemNotFoundException;
	public void updatedMenuItems(MenuItem menuItem, int id);
}
