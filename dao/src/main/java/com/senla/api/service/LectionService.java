package com.senla.api.service;

import java.util.Collection;
import java.util.List;

import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.dao.search.SortParam;
import com.senla.entity.Lection;
import com.senla.entity.util.DictionaryItem;

public interface LectionService extends AbstractService<Lection>, Searchable<LectionSearchParams, Lection> {

	void addPairToLection(Long idPair, Long idLection);

	void removePairFromLection(Long idLection);

	List<Lection> getLectionsByCourseId(Long idCourse);

	Collection<Lection> getLectionsWithoutCourse();

}
