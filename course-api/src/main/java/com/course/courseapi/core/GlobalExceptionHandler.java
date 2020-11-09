package com.course.courseapi.core;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler({BaseException.class})
	public JsonResponse handleApiRequestrException(BaseException e) {
		System.out.println("---------------------->0");
		JsonResponse response = new JsonResponse();
		response.setErrorCode(e.errorCode);
		response.setErrorDesc(e.errorDesc);
		response.setErrorMessage(e.errorMessage);
		response.setSuccessStatus(e.successStatus);
		return response;
		
	}
	@ExceptionHandler({NullPointerException.class})
	public JsonResponse handleApiRequestrException11(NullPointerException e) {
		System.out.println("----------------------11");
		JsonResponse response = new JsonResponse();
		response.setErrorCode("1111111");
		response.setErrorDesc("null poin");
		response.setErrorMessage("123");
		return response;
		
	}


}
