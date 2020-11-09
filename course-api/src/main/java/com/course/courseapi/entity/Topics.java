package com.course.courseapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topics {
	private String topicName;
	@Id @GeneratedValue
	private int topicId;
	private String topicDesc;
	
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public int getTopicId() { 
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicDesc() {
		return topicDesc;
	}
	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}
	
	
	public Topics() {
		
	}
	
	public Topics(String topicName, int topicId, String topicDesc) {
		super();
		this.topicName = topicName;
		this.topicId = topicId;
		this.topicDesc = topicDesc;
	}
	
	
	
	
}
