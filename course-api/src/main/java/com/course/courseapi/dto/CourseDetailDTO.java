package com.course.courseapi.dto;

public class CourseDetailDTO {
	
	private int courseId;
	
	private String courseName;
	
	private String courseDesc;
	
	public CourseDetailDTO() {
		
	}

	public CourseDetailDTO(int courseId, String courseName, String courseDesc) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	

}
