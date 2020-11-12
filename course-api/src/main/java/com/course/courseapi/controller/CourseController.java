package com.course.courseapi.controller;

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
import com.course.courseapi.service.CourseDetailService;

@RestController
public class CourseController {

	@Autowired
	private CourseDetailService courseDetailService;

	@GetMapping("/test")
	public JsonResponse test() {
		return JsonResponse.setJsonResponse("", "", "", courseDetailService.test(), true);
	}

	@RequestMapping("/course")
	public JsonResponse getAllCourse() {
		return JsonResponse.setJsonResponse("", "", "", courseDetailService.getAllCources(), true);
	}

	@PostMapping("/course/addCourse")
	public JsonResponse addCourse(@RequestBody Course course) {

		return JsonResponse.setJsonResponse("", "", "", courseDetailService.addCourse(course), true);
	}

	@GetMapping("/course/get-course-by-id/{id}")
	public JsonResponse getCourseById(@PathVariable("id") int id) {
		return JsonResponse.setJsonResponse("", "", "", courseDetailService.getCourseById(id), true);
	}

	@GetMapping("/course/get-cousre-by-name/{name}")
	public JsonResponse getCouseByName(@PathVariable("name") String name) {
		return JsonResponse.setJsonResponse("", "", "", courseDetailService.getCourseByName(name), true);
	}

	@PutMapping("/course/update-courseName/{courseName}")
	public JsonResponse updateCourseName(@PathVariable("courseName") String courseName, @RequestBody int courseId) {
		courseDetailService.updateCourse(courseId, courseName);
		return JsonResponse.setJsonResponse("", "", "", "", true);
	}

	@PostMapping("/course/add-subj-to-course/{id}")
	public JsonResponse addSubjectToCourseById(@PathVariable("id") int id, @RequestBody Subject subject) {
		return JsonResponse.setJsonResponse("", "", "", courseDetailService.addSubjectToCourseById(id, subject),
				true);

	}

}
