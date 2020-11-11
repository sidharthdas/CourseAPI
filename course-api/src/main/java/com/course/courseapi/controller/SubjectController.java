package com.course.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.core.JsonResponse;
import com.course.courseapi.entity.Subject;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.service.SubjectDetailService;

@RestController
public class SubjectController {

	@Autowired
	SubjectDetailService subjectDetailService;

	@PostMapping("/subject")
	public JsonResponse getAllSubject() {
		return JsonResponse.setJsonResponse("", "", "", subjectDetailService.getAllSubject(), "");
	}

	@PostMapping("/subject/add-Subject")
	public JsonResponse addSubject(@RequestBody Subject subject) {
		subjectDetailService.addSubject(subject);
		return JsonResponse.setJsonResponse("", "", "", "", "True");
	}

	@GetMapping("/subject/get-subject-byId/{id}")
	public JsonResponse getSubjectById(@PathVariable("id") int id) {
		return JsonResponse.setJsonResponse("", "", "", subjectDetailService.getSubjectById(id), "");
	}

	@GetMapping("/subject/get-subject-byName/{name}")
	public JsonResponse getSubjectByName(@PathVariable("name") String name) {
		return JsonResponse.setJsonResponse("", "", "", subjectDetailService.getSubjectByName(name), "True");
	}

	@PostMapping("/subject/add-topic-to-subject/{id}")
	public JsonResponse addTopicToSubject(@PathVariable("id") int id, @RequestBody Topics topics) {
		return JsonResponse.setJsonResponse("", "", "", subjectDetailService.addTopicToSubject(id, topics), "True");

	}

}
