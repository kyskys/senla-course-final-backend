package com.senla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "timetable")
public class Timetable extends AbstractEntity {

	@Column(name = "pair_id")
	private Long pairId;

	@Column(name = "group_id")
	private Long groupId;

	public Long getPairId() {
		return pairId;
	}

	public void setPairId(Long pairId) {
		this.pairId = pairId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
