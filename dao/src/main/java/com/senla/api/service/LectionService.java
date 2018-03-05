package com.senla.api.service;

import com.senla.dao.search.LectionSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Lection;

public interface LectionService extends AbstractService<Lection>, Searchable<LectionSearchParams, Lection> {

	void addPairToLection(Long idPair, Long idLection);

	void removePairFromLection(Long idLection);

}
