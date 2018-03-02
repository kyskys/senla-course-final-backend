package com.senla.api.dao;

import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Lection;

public interface LectionDao extends AbstractDao<Lection>, Searchable<LectionSearchParams, Lection> {

	void removeCourseFromLection(Long idLection);

	void removePairFromLection(Long idLection);

	void addCourseToLection(Long idCourse, Long idLection);

	void addPairToLection(Long idPair, Long idLection);

}
