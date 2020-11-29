package com.course.courseapi.service;

import java.util.List;

import com.course.courseapi.entity.User;

public interface UserService {

	void addUser(User user);
	User getUserByEmail(String email);
	List<User> getAllUser();
	List<User> getUserWithSimilarCourse(String courseName);
	User updateUserDetailsByUserEmail(User user);
	void deleteUser(String userEmail);
	

}
