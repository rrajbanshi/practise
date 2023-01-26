package com.sprink.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprink.api.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{

}
