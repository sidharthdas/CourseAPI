package com.course.courseapi.service;

import java.util.List;

import com.course.courseapi.entity.Course;
import com.course.courseapi.entity.Subject;
import com.course.courseapi.exception.CourseException;

public interface CourseDetailService {
	
	public int test();
	public Course addCourse(Course c);
	public List<Course> getAllCources();
	public List<Course> getCourseById(int id);
	public Course updateCourse(int courseId, String courseName);
	public Course addSubjectToCourseById(int id, Subject subject);
	public List<Course> getCourseByName(String name);
}
