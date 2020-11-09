package com.course.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.entity.Subject;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.service.SubjectDetailService;

@RestController
public class SubjectController {
	
	@Autowired
	SubjectDetailService subjectDetailService;
	
	@PostMapping("/subject")
	public List<Subject> getAllSubject(){
		return subjectDetailService.getAllSubject();
	}
	
	@PostMapping("/subject/add-Subject")
	public void addSubject(@RequestBody Subject subject) {
		subjectDetailService.addSubject(subject);
	}
	
	@GetMapping("/subject/get-subject-byId/{id}")
	public List<Subject> getSubjectById(@PathVariable("id") int id) {
		return subjectDetailService.getSubjectById(id);
	}
	
	@GetMapping("/subject/get-subject-byName/{name}")
	public List<Subject> getSubjectByName(@PathVariable("name")String name){
		return subjectDetailService.getSubjectByName(name);
	}
	
	@PostMapping("/subject/add-topic-to-subject/{id}")
	public Subject addTopicToSubject(@PathVariable("id") int id,@RequestBody Topics topics) {
		
		return subjectDetailService.addTopicToSubject(id, topics);
		
	}

}
