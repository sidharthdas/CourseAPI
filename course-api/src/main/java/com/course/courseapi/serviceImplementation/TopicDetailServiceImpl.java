package com.course.courseapi.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseapi.dao.TopicDetailDAO;
import com.course.courseapi.entity.Topics;
import com.course.courseapi.service.TopicDetailService;

@Service
public class TopicDetailServiceImpl implements TopicDetailService {

	@Autowired
	public TopicDetailDAO topicDetailDAO;
	
	@Override
	public void addTopic(Topics topic) {
		// TODO Auto-generated method stub
		List<Topics> topicNamelist = topicDetailDAO.getTopicByName(topic.getTopicName());
		if(topicNamelist.isEmpty())
			topicDetailDAO.save(topic);
	}

	@Override
	public List<Topics> getTopicById(int id) {
		// TODO Auto-generated method stub
		List<Topics> tlist = topicDetailDAO.getTopicById(id);
		return tlist;
	}

	@Override
	public List<Topics> getTopicByName(String name) {
		// TODO Auto-generated method stub
		List<Topics> topicNamelist = topicDetailDAO.getTopicByName(name);
		return topicNamelist;
	}

}
