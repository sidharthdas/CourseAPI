package com.course.courseapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.course.courseapi.entity.User;

public interface UserDAO extends CrudRepository<User, Long> {

}
