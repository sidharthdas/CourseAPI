package com.course.courseapi.core;

public class ExceptionErrors {
	
		// Error Codes
		public static final String NULLOBEJCTERRORCODE = "1001";
		public static final String OBJECTALREADYPRESENTCODE = "1002";
		public static final String SUBJECTALLREADYPRESENTINTHECOURSECODE = "1003";
		
	
		//Error Messages
		public static final String NULLOBJECTERRORMESSAGE = "Object is Null";
		public static final String OBJECTALREADYPRESENTMESSAGE = "Object is Present";
		public static final String SUBJECTALLREADYPRESENTINTHECOURSEMESSAGE = "Duplicate Subject";
		
	
		//Error Desc
		public static final String NULLOBJECTERRORDESC = "Object is Null comming from Front-end";
		public static final String OBJECTALREADYPRESENTDESC = "Object is present in the DB. Duplicate entry not allowed. ";
		public static final String SUBJECTALLREADYPRESENTINTHECOURSEDESC = "Subject is already added to the course. ";


}
