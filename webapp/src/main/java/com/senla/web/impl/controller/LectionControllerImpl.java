package com.senla.web.impl.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.api.service.CourseService;
import com.senla.api.service.LectionService;
import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Lection;
import com.senla.web.api.controller.LectionController;
import com.senla.web.dto.CreateGroupOrLectionDto;
import com.senla.web.dto.LectionDto;
import com.senla.web.dto.LectionGetDto;

@RestController
public class LectionControllerImpl implements LectionController {

	@Autowired
	LectionService lectionService;
	@Autowired
	CourseService courseService;

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
			courseService.addLectionToCourse(id, idCourse);
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
	public List<LectionGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "course", required = false) String course, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		LectionSearchParams searchParam = new LectionSearchParams(id, name, pair, course);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<LectionGetDto> result = lectionService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(LectionGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "/api/lection/count", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Long lectionCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "course", required = false) String course,
			@RequestParam(value = "pair", required = false) String pair) {
		LectionSearchParams searchParam = new LectionSearchParams(id, name, pair, course);
		return lectionService.count(searchParam);
	}
	
	@RequestMapping(value = "/api/lection/{lection}/remove", method = RequestMethod.POST)
	@Override
	public void removePairFromLection(@PathVariable("lection") Long idLection) {
		lectionService.removePairFromLection(idLection);
	}

	@RequestMapping(value = "/api/lection/{lection}/add/pair/{pair}", method = RequestMethod.POST)
	@Override
	public void addPairToLection(@PathVariable("pair") Long idPair, @PathVariable("lection") Long idLection) {
		lectionService.addPairToLection(idPair, idLection);
	}
}
