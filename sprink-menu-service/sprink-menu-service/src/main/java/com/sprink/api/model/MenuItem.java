package com.sprink.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table

public class MenuItem {
	@Id
	@GeneratedValue
	private int id;
	@NotNull(message="Menu Item can not be null")
	@NotBlank(message="Menu Item can not be blank")
	private String name;
	@NotNull(message="Menu Item description can not be null")
	@NotBlank(message="Menu Item description can not be blank")
	private String description;
	@NotNull(message="Menu Item Price can not be null")
	private double price;
	private MenuItemType type;
	private CusineType cusineType;
	private MealSession mealsession;
	private PortionSize portionSize;
	private LocalDateTime createdTime;
	private LocalDateTime UpdatedTime;
	private String createdBy;
	private String UpdatedBy;
	

}
