package com.senla.api.service;

import java.util.List;

import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Mark;

public interface MarkService extends AbstractService<Mark>, Searchable<MarkSearchParams, Mark> {

	void cloneMarkToPair(Long idPair, Long idMark);

	void cloneMarkToStudent(Long idStudent, Long idMark);

	List<Mark> getMarksByStudentId(Long idStudent);

	List<Mark> getMarksByPairId(Long idPair);
}
