package com.senla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lection")
public class Lection extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	@Column(name="name")
	private String name;
	
	@OneToOne(mappedBy="lection")
	private Pair pair;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
