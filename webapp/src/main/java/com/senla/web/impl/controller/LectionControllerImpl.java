package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.senla.api.service.LectionService;
import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Lection;
import com.senla.web.api.controller.LectionController;
import com.senla.web.dto.CreateGroupOrLectionDto;
import com.senla.web.dto.LectionDto;

public class LectionControllerImpl implements LectionController {

	@Autowired
	LectionService lectionService;

	@RequestMapping(value = "/api/lection/{id}/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public LectionDto getLection(@PathVariable("id") Long id) {
		return new LectionDto(lectionService.get(id));
	}

	@RequestMapping(value = "/api/lection/", method = RequestMethod.PUT)
	@Override
	public void createLection(@RequestBody CreateGroupOrLectionDto dto) {
		Lection lection = new Lection();
		lection.setName(dto.getName());
		lectionService.create(lection);
	}

	@RequestMapping(value = "/api/lection/{id}", method = RequestMethod.DELETE)
	@Override
	public void deleteLection(@PathVariable("id") Long id) {
		Lection lection = new Lection();
		lection.setId(id);
		lectionService.delete(lection);
	}

	@RequestMapping(value = "/api/lection/{id}", method = RequestMethod.POST)
	@Override
	public void updateLection(LectionDto dto, @PathVariable("id") Long id) {
		Lection lection = new Lection();
		lection.setId(id);	
		lection.setName(dto.getName());
		Long idPair = dto.getPair();
		Long idCourse = dto.getCourse();
		if (idPair != null) {
			lectionService.addPairToLection(idPair, id);
		}
		if (idCourse != null) {
			lectionService.addCourseToLection(idCourse, id);
		}
		lectionService.update(lection);
	}

	@RequestMapping(value = "/api/lection/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<LectionDto> getAllLections() {
		return lectionService.getAll().stream().map(LectionDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/lection/search", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<LectionDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pair", required = false) Long pair, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset,@RequestParam("asc") boolean asc) {
		LectionSearchParams searchParam = new LectionSearchParams(id, name, pair);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<LectionDto> result = lectionService.search(sortParam, searchParam, limit, offset,asc).stream()
				.map(LectionDto::new).collect(Collectors.toList());
		return result;
	}

}
