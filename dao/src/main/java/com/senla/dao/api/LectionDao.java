package com.senla.dao.api;

import java.util.List;

import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Lection;

public interface LectionDao extends AbstractDao<Lection>, Searchable<LectionSearchParams, Lection> {

	void removePairFromLection(Long idLection);

	void addPairToLection(Long idPair, Long idLection);

	List<Lection> getLectionsByCourseId(Long idCourse);

	List<Lection> getLectionsWithoutCourse();

}
