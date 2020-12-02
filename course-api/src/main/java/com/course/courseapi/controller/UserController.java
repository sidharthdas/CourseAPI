package com.course.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseapi.core.JsonResponse;
import com.course.courseapi.entity.User;
import com.course.courseapi.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		binder.setDisallowedFields("");
	}

	@PostMapping("/add-user")
	public JsonResponse addUser(@RequestBody User user) {
		return JsonResponse.setJsonResponse("", "", "", userService.addUser(user), true);
	}

	@GetMapping("/all-users")
	public JsonResponse getAllUser() {
		return JsonResponse.setJsonResponse("", "", "", userService.getAllUser(), true);
	}

	@PostMapping("/get-user-by-email")
	public JsonResponse addUser(@RequestBody String userEmail) {
		return JsonResponse.setJsonResponse("", "", "", userService.getUserByEmail(userEmail), true);
	}

	@PutMapping("/update-user")
	public JsonResponse updateUserDetailsByUserEmail(@RequestBody User user) {
		return JsonResponse.setJsonResponse("", "", "", userService.updateUserDetailsByUserEmail(user), true);
	}

	@DeleteMapping("/delete-user")
	public JsonResponse deleteUser(@RequestBody String userEmail) {
		return JsonResponse.setJsonResponse("", "", "", null, true);
	}

	@PostMapping("/get-user-with-similar-courses")
	public JsonResponse getUserWithSimilarCourse(@RequestBody String courseName) {
		return JsonResponse.setJsonResponse("", "", "", userService.getUserWithSimilarCourse(courseName), true);
	}

}
