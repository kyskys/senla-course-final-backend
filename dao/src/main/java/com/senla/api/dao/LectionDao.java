package com.senla.api.dao;

import java.util.List;

import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.dao.search.SortParam;
import com.senla.entity.Lection;
import com.senla.entity.util.DictionaryItem;

public interface LectionDao extends AbstractDao<Lection>, Searchable<LectionSearchParams, Lection> {

	void removePairFromLection(Long idLection);

	void addPairToLection(Long idPair, Long idLection);

	List<Lection> getLectionsByCourseId(Long idCourse);

	List<Lection> getLectionsWithoutCourse();

}
