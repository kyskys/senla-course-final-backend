package com.senla.web.api.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.senla.web.dto.CreatePairDto;
import com.senla.web.dto.PairGetDto;
import com.senla.web.dto.PairUpdateDto;

public interface PairController {
	PairGetDto getPair(Long id);

	void createPair(CreatePairDto dto);

	void deletePair(Long id);

	void updatePair(PairUpdateDto dto, Long id);

	List<PairGetDto> getAllPairs();

	List<PairGetDto> search(String sortBy, Long id, LocalDateTime date, String lection, LocalTime startTime,
			LocalTime endTime, Integer limit, Integer offset, boolean asc);

	Long pairCount(Long id, LocalDateTime date, String lection, LocalTime startTime, LocalTime endTime);

}
