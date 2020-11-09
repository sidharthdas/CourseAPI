package com.course.courseapi.exception;

public class TestException extends RuntimeException{
	
	private String errMesg;
	
	
	public TestException(String errMsg) {
		this.errMesg = errMsg;
	}
	

}
