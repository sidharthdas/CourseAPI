package com.course.courseapi.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseapi.dao.CourseDetailDAO;
import com.course.courseapi.dao.SubjectDetailDAO;
import com.course.courseapi.entity.Course;
import com.course.courseapi.entity.Subject;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.service.SubjectDetailService;


@Service
public class SubjectDetailServiceImplementation implements SubjectDetailService{

	@Autowired
	public SubjectDetailDAO subjectDetailDAO;
	
	@Autowired
	public CourseDetailDAO courseDetailDAO;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return subjectDetailDAO.getAllSubject();
		 
	}

	@Override
	public void addSubject(Subject s) {
		// TODO Auto-generated method stub
		List<Subject> subjectNamelist = subjectDetailDAO.getSubjectByName(s.getSubjectName());
		if(subjectNamelist.isEmpty())
			subjectDetailDAO.save(s);
		
	}

	@Override
	public List<Subject> getSubjectById(int id) {
		// TODO Auto-generated method stub
		List<Subject> subjectlist = subjectDetailDAO.getSubjectById(id);
		return subjectlist;
	}

	@Override
	public Subject addTopicToSubject(int subjectId, Topics topics) {
		// TODO Auto-generated method stub
		List<Subject> sublist = subjectDetailDAO.getSubjectById(subjectId);
		if(sublist.isEmpty()) {
			System.out.println("No subject found");
			return null;
		}
		if(Objects.nonNull(sublist.get(0).getTopics())) {
			sublist.get(0).getTopics().add(topics);
			subjectDetailDAO.save(sublist.get(0));
		}
		else {
			List<Topics> topic = new ArrayList<>();
			topic.add(topics);
			sublist.get(0).setTopics(topic);
			subjectDetailDAO.save(sublist.get(0));
			
		}
			
		return sublist.get(0);
	}

	@Override
	public List<Subject> getSubjectByName(String name) {
		// TODO Auto-generated method stub
		List<Subject> subjectNamelist = subjectDetailDAO.getSubjectByName(name);
		return subjectNamelist;
	}


	

	

	

}
