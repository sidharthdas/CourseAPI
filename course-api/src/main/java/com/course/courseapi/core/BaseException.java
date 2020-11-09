package com.course.courseapi.core;

public class BaseException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 31L;
	
	
	protected String errorCode;
	protected String errorMessage;
	protected String errorDesc;
	protected String successStatus;
	
	public BaseException(String errorCode, String errorMessage,Throwable cause)
	{
		super(cause);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		
	}	
	
	public BaseException(Throwable cause)
	{
		super(cause);
	}	
	public BaseException(String errorCode, String errorMessage, String errorDesc, String successStatus) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorDesc = errorDesc;
		this.successStatus = successStatus;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public String getSuccessStatus() {
		return successStatus;
	}
	public void setSuccessStatus(String successStatus) {
		this.successStatus = successStatus;
	}
	
	
	

}
