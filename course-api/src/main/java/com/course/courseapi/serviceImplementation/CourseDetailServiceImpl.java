package com.course.courseapi.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.course.courseapi.core.ExceptionErrors;
import com.course.courseapi.dao.CourseDetailDAO;
import com.course.courseapi.entity.Course;
import com.course.courseapi.entity.Subject;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.exception.CourseException;
import com.course.courseapi.exception.NullObjectException;
import com.course.courseapi.exception.TestException;
import com.course.courseapi.service.CourseDetailService;

@Service // By default Singleton
//@Scope("prototype")
public class CourseDetailServiceImpl implements CourseDetailService {

	@Autowired
	private CourseDetailDAO courseDetailDAO;

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Course> getAllCources() {
		// TODO Auto-generated method stub
		return courseDetailDAO.getAllCourse();
	}

	@Override
	public Course addCourse(Course c) {
		// TODO Auto-generated method stub
		if (Objects.isNull(c.getCourseName())) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		List<Course> cousreNamelist = courseDetailDAO.getCourseName(c.getCourseName());
		if (cousreNamelist.isEmpty()) {
			courseDetailDAO.save(c);

			return c;
		} else {
			throw new NullObjectException(ExceptionErrors.OBJECTALREADYPRESENTCODE,
					ExceptionErrors.OBJECTALREADYPRESENTMESSAGE, ExceptionErrors.OBJECTALREADYPRESENTDESC, false);
		}

	}

	@Override
	public List<Course> getCourseById(int id) {
		if (Objects.isNull((id))) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		List<Course> courselist = courseDetailDAO.getCourseById(id);
		return courselist;
	}

	@Override
	public Course updateCourse(int courseId, String courseName) {
		if (Objects.isNull(courseId) || Objects.isNull(courseName)) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		List<Course> course = courseDetailDAO.getCourseById(courseId);
		course.get(0).setCourseName(courseName);
		courseDetailDAO.save(course.get(0));
		return course.get(0);
	}

	@Override
	public Course addSubjectToCourseById(int id, Subject subject) {
		if (Objects.isNull(id) || Objects.isNull(subject)) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		List<Course> courses = courseDetailDAO.getCourseById(id);
		if (Objects.nonNull(courses.get(0).getSubject())) {
			for (Subject s : courses.get(0).getSubject()) {
				if (s.getSubjectName().equalsIgnoreCase(subject.getSubjectName())) {
					throw new CourseException(ExceptionErrors.SUBJECTALLREADYPRESENTINTHECOURSECODE,
							ExceptionErrors.SUBJECTALLREADYPRESENTINTHECOURSEMESSAGE,
							ExceptionErrors.SUBJECTALLREADYPRESENTINTHECOURSEDESC, false);
				}

			}
			courses.get(0).getSubject().add(subject);

			courseDetailDAO.save(courses.get(0));

		} else {
			List<Subject> subjects = new ArrayList<>();
			subjects.add(subject);
			courses.get(0).setSubject(subjects);
			courseDetailDAO.save(courses.get(0));
		}

		return courses.get(0);
	}

	@Override
	public List<Course> getCourseByName(String name) {
		if (Objects.isNull(name)) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		List<Course> coursenamelist = courseDetailDAO.getCourseName(name);
		return coursenamelist;
	}

	// Exception testing
	@Override
	public int test() {
		try {
			int i = 10 / 0;
		} catch (Exception e) {
			throw new NullObjectException(ExceptionErrors.NULLOBEJCTERRORCODE, ExceptionErrors.NULLOBJECTERRORMESSAGE,
					ExceptionErrors.NULLOBJECTERRORDESC, false);
		}
		// throw new CourseException("1001", "test", "test", "Ok");
		return 0;
	}

	private void test1() {
		throw new TestException("123");
	}

	@Override
	public void deleteCourseById(int courseId) {
		// TODO Auto-generated method stub
		List<Course> course = courseDetailDAO.getCourseById(courseId);
		if (course.size() == 0) {
			throw new CourseException(ExceptionErrors.COURSENOTFOUNDCODE,
					ExceptionErrors.COURSENOTFOUNDMESSAGE , ExceptionErrors.COURSENOTFOUNDDESC + courseId, false);
		} else {
			courseDetailDAO.delete(course.get(0));
		}

	}

	@Override
	public Course updateCourseDescByCourseId(int courseId, String courseDesc) {
		// TODO Auto-generated method stub
		List<Course> course = courseDetailDAO.getCourseById(courseId);
		if (course.size() == 0) {
			throw new CourseException(ExceptionErrors.COURSENOTFOUNDCODE,
					ExceptionErrors.COURSENOTFOUNDMESSAGE , ExceptionErrors.COURSENOTFOUNDDESC + + courseId, false);
		}
		course.get(0).setCourseDesc(courseDesc);
		courseDetailDAO.save(course.get(0));
		return course.get(0);
	}
}
