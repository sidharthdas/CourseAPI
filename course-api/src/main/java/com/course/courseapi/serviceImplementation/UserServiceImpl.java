package com.course.courseapi.serviceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseapi.core.ExceptionErrors;
import com.course.courseapi.dao.CourseDetailDAO;
import com.course.courseapi.dao.UserDAO;
import com.course.courseapi.entity.Course;
import com.course.courseapi.entity.User;
import com.course.courseapi.exception.NullObjectException;
import com.course.courseapi.exception.UserException;
import com.course.courseapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CourseDetailDAO courseDAO;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		if (Objects.isNull(user)) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}

		List<User> users = userDAO.getUserByEmail(user.getUserEmail().toLowerCase());
		if (users.size() != 0) {
			throw new UserException(ExceptionErrors.USERALREADYEXISTCODE, ExceptionErrors.USERALREADYEXISTMESSAGE,
					ExceptionErrors.USERNALREADYEXISTDESC + " " + user.getUserEmail(), false);
		} else {
			User user1 = new User();
			user1.setUserEmail(user.getUserEmail().toLowerCase());
			user1.setUserName(user.getUserName());
			user1.setUserPhoneNumber(user.getUserPhoneNumber());
			userDAO.save(user);
		}
		return user;

	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		if (Objects.isNull(email)) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		List<User> user = userDAO.getUserByEmail(email.toLowerCase());
		return user.get(0);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userDAO.findAll();
	}

	@Override
	public List<User> getUserWithSimilarCourse(String courseName) {
		// TODO Auto-generated method stub
		List<User> allUsers = (List<User>) userDAO.findAll();
		List<Course> course = courseDAO.getCourseName(courseName);
		return null;
	}

	@Override
	public User updateUserDetailsByUserEmail(User user) {
		// TODO Auto-generated method stub
		if (Objects.isNull(user)) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		List<User> users = userDAO.getUserByEmail(user.getUserEmail());
		if (users.size() == 0) {
			throw new UserException(ExceptionErrors.USERNOTFOUNDCODE, ExceptionErrors.USERNOTFOUNDMESSAGE,
					ExceptionErrors.USERNOTFOUNDDESC, false);
		}
		userDAO.save(user);
		return user;
	}

	@Override
	public void deleteUser(String userEmail) {
		// TODO Auto-generated method stub
		if (Objects.isNull(userEmail)) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}

		List<User> users = userDAO.getUserByEmail(userEmail);
		if (users.size() == 0) {
			throw new UserException(ExceptionErrors.USERNOTFOUNDCODE, ExceptionErrors.USERNOTFOUNDMESSAGE,
					ExceptionErrors.USERNOTFOUNDDESC, false);
		} else {
			userDAO.delete(users.get(0));
		}

	}

}
