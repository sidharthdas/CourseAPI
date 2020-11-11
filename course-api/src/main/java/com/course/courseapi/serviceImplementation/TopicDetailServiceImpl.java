package com.course.courseapi.serviceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseapi.dao.TopicDetailDAO;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.exception.CourseException;
import com.course.courseapi.service.TopicDetailService;

@Service
public class TopicDetailServiceImpl implements TopicDetailService {

	@Autowired
	public TopicDetailDAO topicDetailDAO;

	@Override
	public void addTopic(Topics topic) {
		if (Objects.isNull(topic)) {
			throw new CourseException("1001", "Null", "Null Values", "False");
		}
		List<Topics> topicNamelist = topicDetailDAO.getTopicByName(topic.getTopicName());
		if (topicNamelist.isEmpty())
			topicDetailDAO.save(topic);
	}

	@Override
	public List<Topics> getTopicById(int id) {
		if (Objects.isNull(id)) {
			throw new CourseException("1001", "Null", "Null Values", "False");
		}
		List<Topics> tlist = topicDetailDAO.getTopicById(id);
		return tlist;
	}

	@Override
	public List<Topics> getTopicByName(String name) {
		if (Objects.isNull(name)) {
			throw new CourseException("1001", "Null", "Null Values", "False");
		}
		List<Topics> topicNamelist = topicDetailDAO.getTopicByName(name);
		return topicNamelist;
	}

}
