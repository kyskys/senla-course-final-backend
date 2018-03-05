package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.LecturerGetDto;
import com.senla.web.dto.LecturerUpdateDto;

public interface LecturerController {
	LecturerGetDto getLecturer(Long id);

	void deleteLecturer(Long id);

	void updateLecturer(LecturerUpdateDto dto, Long id);

	List<LecturerGetDto> getAllLecturers();

	List<LecturerGetDto> search(String sortBy, Long id, String name, String email, Integer number, Integer limit,
			Integer offset, boolean asc);

	Long lecturerCount(Long id, String name, String email, Integer number);
	
	void addCourseToLecturer(Long idCourse, Long idLecturer);
}
