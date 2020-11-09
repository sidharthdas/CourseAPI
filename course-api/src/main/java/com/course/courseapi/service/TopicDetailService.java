package com.course.courseapi.service;

import java.util.List;

import com.course.courseapi.entity.Topics;

public interface TopicDetailService {
	
	public void addTopic(Topics topic);
	public List<Topics> getTopicById(int id);
	public List<Topics> getTopicByName(String name);

}
