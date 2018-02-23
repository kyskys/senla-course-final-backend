package com.senla.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "pair")
@SecondaryTable(name = "pair_time")
public class Pair extends AbstractEntity {

	@OneToOne
	@JoinColumn(name = "lection_id")
	private Lection lection;

	@OneToOne
	@JoinColumn(name = "pair_time_id")
	private PairTime time;

	@Column(name = "date")
	private LocalDateTime date;

	@ManyToMany(mappedBy = "pairs")
	private List<Group> groups;

	@OneToMany(mappedBy = "pair")
	private List<Mark> marks;

	public Lection getLection() {
		return lection;
	}

	public void setLection(Lection lection) {
		this.lection = lection;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public PairTime getTime() {
		return time;
	}

	public void setTime(PairTime time) {
		this.time = time;
	}
}
