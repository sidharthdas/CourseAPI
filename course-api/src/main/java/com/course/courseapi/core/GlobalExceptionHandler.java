package com.course.courseapi.core;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Core Exception handler Class
 */
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // If any exception occurs, the pointer will come to this class as this is
						// annotated with @RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ BaseException.class }) // Request comes as per the Exception class
	public JsonResponse handleApiRequestrException(BaseException e) {
		System.out.println("---------------------->0");
		JsonResponse response = new JsonResponse();
		response.setErrorCode(e.errorCode);
		response.setErrorDesc(e.errorDesc);
		response.setErrorMessage(e.errorMessage);
		response.setSuccessStatus(e.successStatus);
		return response;

	}

	@ExceptionHandler({ NullPointerException.class })
	public JsonResponse handleApiRequestrException11(NullPointerException e) {
		System.out.println("----------------------11");
		JsonResponse response = new JsonResponse();
		response.setErrorCode("1111111");
		response.setErrorDesc("null poin");
		response.setErrorMessage("123");
		return response;

	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public JsonResponse MethodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("----------------------11");
		JsonResponse response = new JsonResponse();
		response.setErrorCode("");
		response.setErrorDesc(e.getLocalizedMessage());
		response.setErrorMessage(e.getMessage());
		return response;

	}

}
