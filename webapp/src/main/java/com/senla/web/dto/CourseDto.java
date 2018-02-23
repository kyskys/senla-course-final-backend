package com.senla.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.senla.entity.Course;

public class CourseDto {
	private Long id;
	private List<Long> lections;
	private String name;
	private String description;
	private Long lecturer;

	public CourseDto(Course course) {
		this.id = course.getId();
		this.lections = course.getLections().stream().map(master -> master.getId()).collect(Collectors.toList());
		this.name = course.getName();
		this.description = course.getDescription();
		this.lecturer = course.getLecturer().getId();
	}

	public Long getId() {
		return id;
	}

	public List<Long> getLections() {
		return lections;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getLecturer() {
		return lecturer;
	}
}
