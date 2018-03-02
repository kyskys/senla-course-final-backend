package com.senla.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.senla.entity.Course;

public class CourseUpdateDto {
	private List<Long> lections;
	private String name;
	private String description;
	private Long lecturer;

	public CourseUpdateDto(Course course) {
		this.name = course.getName();
		this.description = course.getDescription();
		if (course.getLections() != null) {
			this.lections = course.getLections().stream().map(master -> master.getId()).collect(Collectors.toList());
		}
		if (course.getLecturer() != null) {
			this.lecturer = course.getLecturer().getId();
		}
	}

	public CourseUpdateDto() {

	}

	public List<Long> getLections() {
		return lections;
	}

	public void setLections(List<Long> lections) {
		this.lections = lections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLecturer() {
		return lecturer;
	}

	public void setLecturer(Long lecturer) {
		this.lecturer = lecturer;
	}
}
