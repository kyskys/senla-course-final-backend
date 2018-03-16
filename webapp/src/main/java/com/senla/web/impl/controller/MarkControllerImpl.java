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

import com.senla.api.service.MarkService;
import com.senla.api.service.PairService;
import com.senla.api.service.StudentService;
import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Mark;
import com.senla.web.api.controller.MarkController;
import com.senla.web.dto.MarkGetDto;
import com.senla.web.dto.MarkUpdateDto;
import com.senla.web.dto.PairMarkDto;
import com.senla.web.dto.CreateMarkDto;

@RestController
@RequestMapping("/api/mark/")
public class MarkControllerImpl implements MarkController {

	@Autowired
	MarkService markService;
	@Autowired
	PairService pairService;
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "{id}/", method = RequestMethod.GET, produces = "application/json")
	@Override
	public MarkGetDto getMark(@PathVariable("id") Long id) {
		return new MarkGetDto(markService.get(id));
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@Override
	public void createMark(@RequestBody CreateMarkDto dto) {
		Mark mark = new Mark();
		mark.setPair(pairService.get(dto.getPair()));
		mark.setStudent(studentService.get(dto.getStudent()));
		mark.setMark(dto.getMark());
		markService.create(mark);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@Override
	public void deleteMark(@PathVariable("id") Long id) {
		Mark Mark = new Mark();
		Mark.setId(id);
		markService.delete(Mark);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@Override
	public void updateMark(@RequestBody MarkUpdateDto dto, @PathVariable("id") Long id) {
		Mark mark = markService.get(id);
		Integer _mark = dto.getMark();
		if(_mark!=null) {
			mark.setMark(_mark);
		}
		Long idPair = dto.getPair();
		if(idPair!=null) {
			mark.setPair(pairService.get(idPair));
		}
		Long idStudent = dto.getStudent();
		if(idStudent!=null) {
			mark.setStudent(studentService.get(idStudent));
		}
		markService.update(mark);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<MarkGetDto> getAllMarks() {
		return markService.getAll().stream().map(MarkGetDto::new).collect(Collectors.toList());
	}

	@RequestMapping(value = "search", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<MarkGetDto> search(@RequestParam(value = "sort", required = false) String sortBy,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "student", required = false) String student, @RequestParam("limit") Integer limit,
			@RequestParam("offset") Integer offset, @RequestParam("asc") boolean asc) {
		MarkSearchParams searchParam = new MarkSearchParams(id, pair, student);
		SortParam sortParam = SortParam.getValueOf(sortBy);
		List<MarkGetDto> result = markService.search(sortParam, searchParam, limit, offset, asc).stream()
				.map(MarkGetDto::new).collect(Collectors.toList());
		return result;
	}

	@RequestMapping(value = "count", method = RequestMethod.GET, produces = "application/json")
	@Override
	public Long markCount(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "pair", required = false) String pair,
			@RequestParam(value = "student", required = false) String student) {
		MarkSearchParams searchParam = new MarkSearchParams(id, pair, student);
		return markService.count(searchParam);
	}

	@RequestMapping(value = "{mark}/clone/pair/{pair}", method = RequestMethod.POST)
	@Override
	public void cloneMarkToPair(@PathVariable("pair") Long idPair, @PathVariable("mark") Long idMark) {
		markService.cloneMarkToPair(idPair, idMark);
	}

	@RequestMapping(value = "{mark}/clone/student/{student}", method = RequestMethod.POST)
	@Override
	public void cloneMarkToStudent(@PathVariable("student") Long idStudent, @PathVariable("mark") Long idMark) {
		markService.cloneMarkToStudent(idStudent, idMark);
	}

	@RequestMapping(value = "pair/{pair}", method = RequestMethod.GET, produces = "application/json")
	public List<PairMarkDto> getMarksByPairId(@PathVariable("pair") Long idPair) {
		return markService.getMarksByPairId(idPair).stream().map(PairMarkDto::new)
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "student/{student}", method = RequestMethod.GET, produces = "application/json")
	public List<PairMarkDto> getMarksByStudentId(@PathVariable("pair") Long idStudent) {
		return markService.getMarksByStudentId(idStudent).stream().map(PairMarkDto::new)
				.collect(Collectors.toList());
	}
}
