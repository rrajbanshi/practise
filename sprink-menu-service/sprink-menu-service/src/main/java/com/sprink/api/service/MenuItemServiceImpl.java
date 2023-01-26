package com.sprink.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sprink.api.exception.MenuItemNotFoundException;
import com.sprink.api.model.MenuItem;
import com.sprink.api.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	MenuItemRepository menuItemRepo;

	@Override
	public MenuItem createMenuItem(MenuItem item) {
		item.setCreatedTime(LocalDateTime.now());
		return menuItemRepo.save(item);
	}

	@Override
	public MenuItem updatedMenuItem(MenuItem item, int id) throws MenuItemNotFoundException  {
		
		Optional<MenuItem>itemOptional= menuItemRepo.findById(id);
		if(itemOptional.isEmpty()) {
			throw new MenuItemNotFoundException("No  Menu item found for given id-"+id);
		}
		item.setId(id);
		item.setUpdatedTime(LocalDateTime.now());
		return  menuItemRepo.save(item);
	}

	@Override
	public List<MenuItem> getMenuItems() {
		
		return menuItemRepo.findAll();
	}

	@Override
	public MenuItem getMenu(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMenuItem(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedMenuItems(MenuItem menuItem, int id) {
		// TODO Auto-generated method stub
		
	}
	

}
