package com.course.courseapi.service;

import java.util.List;

import com.course.courseapi.entity.Subject;
import com.course.courseapi.entity.Topics;

public interface SubjectDetailService {
	
	public List<Subject> getAllSubject();
	public void addSubject(Subject s);
	public List<Subject> getSubjectById(int id);
	public List<Subject> getSubjectByName(String name);
	public Subject addTopicToSubject(int subjectId,Topics topics);

}
