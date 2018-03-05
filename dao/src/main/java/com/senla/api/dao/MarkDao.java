package com.senla.api.dao;

import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Mark;

public interface MarkDao extends AbstractDao<Mark>, Searchable<MarkSearchParams, Mark> {

	void cloneMarkToPair(Long idPair, Long idMark);

	void cloneMarkToStudent(Long idStudent, Long idMark);

}
