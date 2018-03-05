package com.senla.web.impl.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.api.service.GroupService;
import com.senla.api.service.LectionService;
import com.senla.api.service.MarkService;
import com.senla.api.service.PairService;
import com.senla.api.service.PairTimeService;
import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Pair;
import com.senla.web.api.controller.PairController;
import com.senla.web.dto.CreatePairDto;
import com.senla.web.dto.PairGetDto;
import com.senla.web.dto.PairUpdateDto;

@RestController
public class PairControllerImpl implements PairController {

	@Autowired
	PairService pairService;
	@Autowired
	LectionService lectionService;
	@Autowired
	PairTimeService pairTimeService;
	@Autowired
	GroupService groupService;
	@Autowired
	MarkService markService;

	@RequestMapping(value = "/api/pair/{id}/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public PairGetDto getPair(@PathVariable("id") Long id) {
		return new PairGetDto(pairService.get(id));
	}

	@RequestMapping(value = "/api/pair/", method = RequestMethod.PUT)
	@Override
	public void createPair(@RequestBody CreatePairDto dto) {
		Pair pair = new Pair();
		pair.setName(dto.getName());
		pairService.create(pair);
	}

	@RequestMapping(value = "/api/pair/{id}", method = RequestMethod.DELETE)
	@Override
	public void deletePair(@PathVariable("id") Long id) {
		Pair pair = new Pair();
		pair.setId(id);
		pairService.delete(pair);
	}

	@RequestMapping(value = "/api/pair/{id}", method = RequestMethod.POST)
	@Override
	public void updatePair(@RequestBody PairUpdateDto dto, @PathVariable("id") Long id) {
		Pair pair = new Pair();
		pair.setId(id);
		pair.setDate(dto.getDate());
		Long idLection = dto.getLection();
		if (idLection != null) {
			pair.setLection(lectionService.get(idLection));
		}
		Long idPairTime = dto.getTime();
		if (idPairTime != null) {
			pair.setTime(pairTimeService.get(idPairTime));
		}
		pair.setName(dto.getName());
		List<Long> groups = dto.getGroups();
		if (groups != null) {
			for (Long idGroup : groups) {
				groupService.addPairToGroup(id, idGroup);
			}
		}
		pairService.update(pair);
	}

	@RequestMapping(value = "/api/pair/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<PairGetDto> getAllPairs() {
		return pairService.getAll().stream().map(PairGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/pair/search", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<PairGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "date", required = false) LocalDateTime date,
			@RequestParam(value = "lection", required = false) String lection,
			@RequestParam(value = "start", required = false) LocalTime startTime,
			@RequestParam(value = "end", required = false) LocalTime endTime, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		PairSearchParams searchParam = new PairSearchParams(id, date, lection, startTime, endTime);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<PairGetDto> result = pairService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(PairGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "/api/pair/count", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Long pairCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "date", required = false) LocalDateTime date,
			@RequestParam(value = "lection", required = false) String lection,
			@RequestParam(value = "start", required = false) LocalTime startTime,
			@RequestParam(value = "end", required = false) LocalTime endTime) {
		PairSearchParams searchParam = new PairSearchParams(id, date, lection, startTime, endTime);
		return pairService.count(searchParam);
	}
}
