package com.course.courseapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.course.courseapi.entity.Course;


public interface CourseDetailDAO extends CrudRepository<Course, Long>{
	
	@Query(value = "Select * from course",nativeQuery = true)
	List<Course> getAllCourse();
	
	@Query(value = "Select * from course where courseId = :courseId",nativeQuery = true)
	List<Course> getCourseById(@Param("courseId")int courseId);
	
	@Query(value = "Select * from course where courseName = :courseName", nativeQuery = true)
	List<Course> getCourseName(@Param("courseName")String courseName);
	
}
