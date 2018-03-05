package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.MarkGetDto;
import com.senla.web.dto.MarkUpdateDto;
import com.senla.web.dto.CreateMarkDto;

public interface MarkController {
	MarkGetDto getMark(Long id);

	void createMark(CreateMarkDto dto);

	void deleteMark(Long id);

	void updateMark(MarkUpdateDto dto, Long id);

	List<MarkGetDto> getAllMarks();

	List<MarkGetDto> search(String sortBy, Long id, String name, String lecturer, Integer limit, Integer offset,
			boolean asc);

	Long markCount(Long id, String pair, String student);

	void cloneMarkToPair(Long idPair, Long idMark);

	void cloneMarkToStudent(Long idStudent, Long idMark);
}
