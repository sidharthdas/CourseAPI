package com.course.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.core.JsonResponse;
import com.course.courseapi.entity.Course;
import com.course.courseapi.entity.Subject;
import com.course.courseapi.exception.CourseException;
import com.course.courseapi.service.CourseDetailService;

@RestController
public class CourseController {

	@Autowired
	private CourseDetailService courseDetailService;
	
	@GetMapping("/test")
	public JsonResponse test(){
		return JsonResponse.setJsonResponse("", "", "", courseDetailService.test(), "ok");
	}
	
	@RequestMapping("/course")
	public JsonResponse getAllCourse(){
	return JsonResponse.setJsonResponse("", "", "", courseDetailService.getAllCources(), "OK");
	}
	
	@PostMapping("/course/addCourse")
	public JsonResponse addCourse(@RequestBody Course course) {
		
		return JsonResponse.setJsonResponse("", "", "", courseDetailService.addCourse(course), "True");
	}
	
	@GetMapping("/course/get-course-by-id/{id}")
	public List<Course> getCourseById(@PathVariable("id")int id)
	{
		return courseDetailService.getCourseById(id);
	}
	
	@GetMapping("/course/get-cousre-by-name/{name}")
	public List<Course> getCouseByName(@PathVariable("name")String name)
	{
		return courseDetailService.getCourseByName(name);
	}
	
	@PutMapping("/course/update-courseName/{courseName}")
	public void updateCourseName(@PathVariable("courseName")String courseName,@RequestBody int courseId)
	{
		 courseDetailService.updateCourse(courseId,courseName);
	}
	
	@PostMapping("/course/add-subj-to-course/{id}")
	public Course addSubjectToCourseById(@PathVariable("id") int id,@RequestBody Subject subject) {
		
		return courseDetailService.addSubjectToCourseById(id, subject);
		
	}
	
	
}
