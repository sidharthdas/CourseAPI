package com.course.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
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

}
