package com.senla.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class Group extends AbstractEntity {

	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<Student> students;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "timetable", 
			joinColumns = @JoinColumn(name = "group_id"), 
			inverseJoinColumns = @JoinColumn(name = "pair_id"))
	private List<Pair> pairs;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	public void setPairs(List<Pair> pairs) {
		this.pairs = pairs;
	}

}
