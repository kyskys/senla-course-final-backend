package com.senla.service.api;

import java.util.List;

import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Mark;

public interface MarkService extends AbstractService<Mark>, Searchable<MarkSearchParams, Mark> {

	List<Mark> getMarksByStudentId(Long idStudent);

	List<Mark> getMarksByPairId(Long idPair);
}
