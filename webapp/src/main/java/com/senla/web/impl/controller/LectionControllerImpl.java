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
import com.senla.api.service.PairService;
import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Lection;
import com.senla.web.dto.CreateGroupOrLectionDto;
import com.senla.web.dto.LectionDto;
import com.senla.web.dto.LectionGetDto;

@RestController
@RequestMapping("/api/lection/")
public class LectionControllerImpl {

	@Autowired
	LectionService lectionService;
	@Autowired
	CourseService courseService;
	@Autowired
	PairService pairService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	public LectionGetDto getLection(@PathVariable("id") Long id) {
		return new LectionGetDto(lectionService.get(id));
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public LectionGetDto createLection(@RequestBody CreateGroupOrLectionDto dto) {
		Lection lection = new Lection();
		lection.setName(dto.getName());
		return new LectionGetDto(lectionService.create(lection));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteLection(@PathVariable("id") Long id) {
		Lection lection = new Lection();
		lection.setId(id);
		lectionService.delete(lection);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public void updateLection(@RequestBody LectionDto dto, @PathVariable("id") Long id) {
		Lection lection = lectionService.get(id);
		String name = dto.getName();
		if(name!=null) {
			lection.setName(name);
		}
		Long idPair = dto.getPair();
		if (idPair != null) {
			lection.setPair(pairService.get(idPair));
		}
		Long idCourse = dto.getCourse();
		if (idCourse != null) {
			lection.setCourse(courseService.get(idCourse));
		}
		lectionService.update(lection);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public List<LectionDto> getAllLections() {
		return lectionService.getAll().stream().map(LectionDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
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

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	public Long lectionCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "course", required = false) String course,
			@RequestParam(value = "pair", required = false) String pair) {
		LectionSearchParams searchParam = new LectionSearchParams(id, name, pair, course);
		return lectionService.count(searchParam);
	}

	@RequestMapping(value = "{lection}/remove", method = RequestMethod.POST)
	public void removePairFromLection(@PathVariable("lection") Long idLection) {
		lectionService.removePairFromLection(idLection);
	}

	@RequestMapping(value = "{lection}/add/pair/{pair}", method = RequestMethod.POST)
	public void addPairToLection(@PathVariable("pair") Long idPair, @PathVariable("lection") Long idLection) {
		lectionService.addPairToLection(idPair, idLection);
	}

	@RequestMapping(value = "course/{course}", method = RequestMethod.GET)
	public List<LectionGetDto> getLectionsByCourseId(@PathVariable("course") Long idCourse) {
		List<LectionGetDto> result = lectionService.getLectionsByCourseId(idCourse).stream()
				.map(LectionGetDto::new).collect(Collectors.toList());
		return result;
	}
	
	@RequestMapping(value = "course/", method = RequestMethod.GET)
	public List<LectionGetDto> getLectionsWithoutCourse() {
		List<LectionGetDto> result = lectionService.getLectionsWithoutCourse().stream()
				.map(LectionGetDto::new).collect(Collectors.toList());
		return result;
	}
}
