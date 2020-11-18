package com.course.courseapi.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TestEntity {
	
	@Min(1)
	private int id;
	@NotNull
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
