package com.senla.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.senla.entity.util.RoleEnum;

@Entity
@DiscriminatorValue(value = RoleEnum.Values.LECTURER)
public class Lecturer extends Person {
	
	{
		this.role = RoleEnum.LECTURER;
	}

	@OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<Course>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
