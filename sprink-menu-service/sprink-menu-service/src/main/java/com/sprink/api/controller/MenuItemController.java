package com.sprink.api.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprink.api.exception.MenuItemNotFoundException;
import com.sprink.api.model.MenuItem;
import com.sprink.api.model.ResponseMessage;
import com.sprink.api.service.MenuItemService;

@RestController
@RequestMapping("/items")
public class MenuItemController {
	
	@Autowired
	MenuItemService menuItemService;
	private MenuItem items;
	
	

	@PostMapping
	public ResponseEntity<ResponseMessage>createItem(@RequestBody @Valid MenuItem menuItem)throws MenuItemNotFoundException, URISyntaxException {
		MenuItem item=menuItemService.createMenuItem(menuItem);
	
		ResponseMessage response =new ResponseMessage();
		response.setStatus("Success");
		response.setMessage("Menu Item Created sucessfully");
		
		return ResponseEntity.created(new URI("http://localhost:8081/sprink/api/items/"+item.getId())).body(response);
		
	}
	
	@GetMapping
	public List<MenuItem> getMenuItens(){
		return menuItemService.getMenuItems();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> updateMenuItem(@RequestBody MenuItem menuItem,@PathVariable int id) throws MenuItemNotFoundException {
		menuItemService.updatedMenuItems(menuItem,id);

		ResponseMessage response =new ResponseMessage();
		response.setStatus("sucess");
		response.setMessage("Menu Item updated sucessfully");
		return ResponseEntity.ok(response);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> deleteMenuItem(@PathVariable int id) {
		ResponseMessage response =new ResponseMessage();
		response.setStatus("Faliure");
		response.setMessage("Menu Item deleted sucessfully");
		return ResponseEntity.ok(response);
	}
	@ExceptionHandler(MenuItemNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleNoMenuItemNotFoundException(MenuItemNotFoundException e) {
        ResponseMessage response = new ResponseMessage();
        response.setStatus("Failure");
        response.setMessage("Server Error: " + e.getMessage());
        return ResponseEntity.internalServerError().body(response);
    }
	
	
	@ExceptionHandler(MenuItemNotFoundException.class)
    public ResponseEntity<ResponseMessage> handleValidateException(MenuItemNotFoundException e) {
        ResponseMessage response = new ResponseMessage();
        response.setStatus("Failure");
        
        
        
        response.setMessage("Server Error: " + e.getMessage());
        return ResponseEntity.internalServerError().body(response);
	
	}
}