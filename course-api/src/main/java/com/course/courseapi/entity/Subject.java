package com.course.courseapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

@Entity
@Audited()
public class Subject {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull
	private String subjectName;
	@NotNull
	private String subjectDesc;
	
	@Version
	private int version;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "subject_id")
	private List<Topics> topics;
	
	public List<Topics> getTopics() {
		return topics;
	}
	public void setTopics(List<Topics> topics) {
		this.topics = topics;
	}
	public int getSubjectId() {
		return id;
	}
	public void setSubjectId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDesc() {
		return subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	

}
