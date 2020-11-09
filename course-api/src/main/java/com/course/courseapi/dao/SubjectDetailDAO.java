package com.course.courseapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.course.courseapi.entity.Subject;

public interface SubjectDetailDAO extends CrudRepository<Subject, Long> {
	
	@Query(value="Select * from subject",nativeQuery=true)
	List<Subject> getAllSubject();
	
	@Query(value="Select * from subject where id =:id",nativeQuery=true)
    List<Subject> getSubjectById(@Param("id")int subjectId);
	
	@Query(value="Select * from subject where subjectName=:subjectName",nativeQuery=true)
	List<Subject> getSubjectByName(@Param("subjectName")String subjectName);
}
