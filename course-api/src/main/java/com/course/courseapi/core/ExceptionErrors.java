package com.course.courseapi.core;

public class ExceptionErrors {
	
		// Error Codes
		public static final String NULLOBEJCTERRORCODE = "1001";
		public static final String OBJECTALREADYPRESENTCODE = "1002";
		public static final String SUBJECTALLREADYPRESENTINTHECOURSECODE = "1003";
		public static final String COURSENOTFOUNDCODE = "1004";
		public static final String USERALREADYEXISTCODE = "1005";
		
		
	
		//Error Messages
		public static final String NULLOBJECTERRORMESSAGE = "Object is Null";
		public static final String OBJECTALREADYPRESENTMESSAGE = "Object is Present";
		public static final String SUBJECTALLREADYPRESENTINTHECOURSEMESSAGE = "Duplicate Subject";
		public static final String COURSENOTFOUNDMESSAGE = "No Course Found.";
		public static final String USERALREADYEXISTMESSAGE = "User Present.";
		
	
		//Error Desc
		public static final String NULLOBJECTERRORDESC = "Object is Null comming from Front-end";
		public static final String OBJECTALREADYPRESENTDESC = "Object is present in the DB. Duplicate entry not allowed. ";
		public static final String SUBJECTALLREADYPRESENTINTHECOURSEDESC = "Subject is already added to the course. ";
		public static final String COURSENOTFOUNDDESC = "Course with the given Id is not available. CourseId : ";
		public static final String USERALREADYEXISTDESC = "User is present for emailId ";


}
