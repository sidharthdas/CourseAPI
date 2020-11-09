package com.course.courseapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.course.courseapi.entity.Topics;

public interface TopicDetailDAO extends CrudRepository<Topics, Long> {
	
	@Query(value="Select * from topics where topicId=:topicId",nativeQuery=true)
	List<Topics> getTopicById(@Param("topicId") int topicId);
	
	@Query(value="select * from topics where topicName=:topicName",nativeQuery=true)
	List<Topics> getTopicByName(@Param("topicName")String topicName);

}
