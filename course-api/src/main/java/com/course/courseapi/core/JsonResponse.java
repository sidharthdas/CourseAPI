package com.course.courseapi.core;

import java.io.Serializable;

/**
 * Core JsonResponse Class.
 * All the controller returns JsonResponse.
 */
public class JsonResponse implements Serializable{


	private String errorCode;
	private String errorMessage;
	private String errorDesc;
	private Object data;
	private boolean successStatus;
	
	public JsonResponse(Object data) {
		this.data = data;
		
	}
	public JsonResponse() {
		
	}

	public JsonResponse(String errorCode, String errorMessage, String errorDesc, Object data, boolean successStatus) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorDesc = errorDesc;
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean getSuccessStatus() {
		return successStatus;
	}

	public void setSuccessStatus(boolean successStatus) {
		this.successStatus = successStatus;
	}

	public static JsonResponse setJsonResponse(String errorCode, String errorMessage, String errorDesc, Object data,
			boolean successStatus) {
		JsonResponse jsonResponse = new JsonResponse(errorCode, errorMessage, errorDesc, data, successStatus);
		return jsonResponse;

	}
	
	public static JsonResponse setJsonResponse(Object data
			) {
		JsonResponse jsonResponse = new JsonResponse( data);
		return jsonResponse;

	}

}
