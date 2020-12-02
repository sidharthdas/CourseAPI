package com.course.courseapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course.courseapi.entity.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

	@Query(value = "SELECT * FROM USER WHERE userEmail =  :userEmail", nativeQuery = true)
	List<User> getUserByEmail(@Param("userEmail") String userEmail);

}
