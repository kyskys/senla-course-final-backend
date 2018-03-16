package com.senla.web.impl.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.senla.dao.util.DateFormatterUtil;
import com.senla.entity.Pair;
import com.senla.entity.util.DictionaryItem;
import com.senla.web.dto.CreatePairDto;
import com.senla.web.dto.GroupPairDto;
import com.senla.web.dto.PairGetDto;
import com.senla.web.dto.PairUpdateDto;
import com.senla.web.dto.TimetableItemDto;

@RestController
@RequestMapping("/api/pair/")
public class PairControllerImpl {

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

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")

	public PairGetDto getPair(@PathVariable("id") Long id) {
		return new PairGetDto(pairService.get(id));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public PairGetDto createPair(@RequestBody CreatePairDto dto) {
		Pair pair = new Pair();
		pair.setName(dto.getName());
		pair.setDate(DateFormatterUtil.getDateFromString(dto.getDate()));
		pair.setLection(lectionService.get(dto.getLection()));
		pair.setTime(pairTimeService.get(dto.getTime()));
		return new PairGetDto(pairService.create(pair));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)

	public void deletePair(@PathVariable("id") Long id) {
		Pair pair = new Pair();
		pair.setId(id);
		pairService.delete(pair);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)

	public void updatePair(@RequestBody PairUpdateDto dto, @PathVariable("id") Long id) {
		Pair pair = pairService.get(id);
		LocalDateTime date = DateFormatterUtil.getDateFromString(dto.getDate());
		if (date != null) {
			pair.setDate(date);
		}
		Long idLection = dto.getLection();
		if (idLection != null) {
			pair.setLection(lectionService.get(idLection));
		}
		Long idPairTime = dto.getTime();
		if (idPairTime != null) {
			pair.setTime(pairTimeService.get(idPairTime));
		}
		String name = dto.getName();
		if (name != null && name != "") {
			pair.setName(dto.getName());
		}
		pairService.update(pair);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")

	public List<PairGetDto> getAllPairs() {
		return pairService.getAll().stream().map(PairGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	public List<PairGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "id", required = false) String name,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "lection", required = false) String lection, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		PairSearchParams searchParam = new PairSearchParams(id, name, DateFormatterUtil.getDateFromString(date),
				lection);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		System.out.println(lection);
		List<PairGetDto> result = pairService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(PairGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long pairCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "id", required = false) String name,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "lection", required = false) String lection) {
		PairSearchParams searchParam = new PairSearchParams(id, name, DateFormatterUtil.getDateFromString(date),
				lection);
		return pairService.count(searchParam);
	}

	@RequestMapping(value = "dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getDictionary() {
		return pairService.getDictionary();
	}

	@RequestMapping(value = "time/dictionary", method = RequestMethod.GET)
	public List<DictionaryItem> getPairTimeDictionary() {
		return pairTimeService.getDictionary();
	}

	@RequestMapping(value = "group/{group}", method = RequestMethod.GET, produces = "application/json")
	public List<GroupPairDto> getPairsByGroupId(@PathVariable("group") Long idGroup) {
		return pairService.getPairsByGroupId(idGroup).stream().map(GroupPairDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "timetable/{group}", method = RequestMethod.GET)
	public List<TimetableItemDto> getTimetableByWeek(@RequestParam("day") String startOfWeek, @PathVariable("group") Long idGroup) {
		//Map<String,List<PairGetDto>> result = new HashMap<String,List<PairGetDto>>();
		LocalDateTime day = DateFormatterUtil.getDateFromString(startOfWeek);
		return pairService.getPairsByWeek(day,idGroup).stream().map(TimetableItemDto::new).collect(Collectors.toList());
	}
	

	@RequestMapping(value = "{id}/add/group", method = RequestMethod.POST)
	public void addGroupsToPair(@PathVariable("id") Long idPair, @RequestBody List<Long> groups) {
		pairService.addGroupsToPair(idPair, groups);
	}
}
