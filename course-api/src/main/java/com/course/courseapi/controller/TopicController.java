package com.course.courseapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.core.JsonResponse;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.service.TopicDetailService;

@RestController
public class TopicController {

	@Autowired
	TopicDetailService topicDetailService;

	@PostMapping("/topics/addTopic")
	public JsonResponse addTopic( @Valid @RequestBody Topics topic) {
		topicDetailService.addTopic(topic);
		return JsonResponse.setJsonResponse("", "", "", "", true);
	}

	@GetMapping("/topics/get-topics-byId/{id}")
	public JsonResponse getTopicById(@PathVariable("id") int id) {
		return JsonResponse.setJsonResponse("", "", "", topicDetailService.getTopicById(id), true);
	}

	@GetMapping("/topic/get-topic-ByName/{name}")
	public JsonResponse getTopicByName(@PathVariable("name") String name) {
		return JsonResponse.setJsonResponse("", "", "", topicDetailService.getTopicByName(name), true);
	}

}
