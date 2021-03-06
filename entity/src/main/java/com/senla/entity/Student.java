package com.senla.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.senla.entity.util.RoleEnum;

@Entity
@DiscriminatorValue(value = RoleEnum.Values.STUDENT)
public class Student extends Person {

	{
		this.role = RoleEnum.STUDENT;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name = "group_students", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Group group;

	@OneToMany(mappedBy = "pair")
	private List<Mark> marks;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

}
