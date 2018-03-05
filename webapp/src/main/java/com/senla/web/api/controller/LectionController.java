package com.senla.web.api.controller;

import java.util.List;

import com.senla.web.dto.CreateGroupOrLectionDto;
import com.senla.web.dto.LectionDto;
import com.senla.web.dto.LectionGetDto;

public interface LectionController {
	LectionDto getLection(Long id);

	void createLection(CreateGroupOrLectionDto dto);

	void deleteLection(Long id);

	void updateLection(LectionDto dto, Long id);

	List<LectionDto> getAllLections();

	List<LectionGetDto> search(String sortBy, Long id, String name, String pair, String course, Integer limit,
			Integer offset, boolean asc);

	Long lectionCount(Long id, String name, String course, String pair);
	
	void removePairFromLection(Long idLection);

	void addPairToLection(Long idPair, Long idLection);

}
