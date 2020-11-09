package com.course.courseapi.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.entity.Topics;
import com.course.courseapi.service.TopicDetailService;

@RestController
public class TopicController {
	
	@Autowired
	TopicDetailService topicDetailService;
	
	@PostMapping("/topics/addTopic")
	public void addTopic(@RequestBody Topics topic) {
		topicDetailService.addTopic(topic);
	}
	
	@GetMapping("/topics/get-topics-byId/{id}")
	public List<Topics> getTopicById(@PathVariable("id") int id) {
		return topicDetailService.getTopicById(id);
	}
	
	
	@GetMapping("/topic/get-topic-ByName/{name}")
	public List<Topics> getTopicByName(@PathVariable("name")String name){
		return topicDetailService.getTopicByName(name);
	}
	
}
