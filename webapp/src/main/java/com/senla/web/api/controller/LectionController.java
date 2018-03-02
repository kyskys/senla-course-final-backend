package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.CreateGroupOrLectionDto;
import com.senla.web.dto.LectionDto;

public interface LectionController {
	LectionDto getLection(Long id);

	void createLection(CreateGroupOrLectionDto dto);

	void deleteLection(Long id);

	void updateLection(LectionDto dto, Long id);

	List<LectionDto> getAllLections();

	List<LectionDto> search(String sortBy, Long id, String name, Long pair, Integer limit, Integer offset, boolean asc);

}
