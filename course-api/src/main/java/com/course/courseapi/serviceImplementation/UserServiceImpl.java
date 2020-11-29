package com.course.courseapi.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseapi.dao.CourseDetailDAO;
import com.course.courseapi.dao.UserDAO;
import com.course.courseapi.entity.User;
import com.course.courseapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CourseDetailDAO courseDAO;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserWithSimilarCourse(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserDetailsByUserEmail(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userEmail) {
		// TODO Auto-generated method stub

	}

}
