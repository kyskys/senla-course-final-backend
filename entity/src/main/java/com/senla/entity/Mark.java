package com.senla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pair_marks")
public class Mark extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "pair_id")
	private Pair pair;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Column(name = "mark")
	private Integer mark;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Pair getPair() {
		return pair;
	}

	public void setPair(Pair pair) {
		this.pair = pair;
	}
}
