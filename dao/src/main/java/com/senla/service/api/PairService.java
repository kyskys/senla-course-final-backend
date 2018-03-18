package com.senla.service.api;

import java.time.LocalDateTime;
import java.util.List;

import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Pair;

public interface PairService extends AbstractService<Pair>, Searchable<PairSearchParams, Pair> {

	List<Pair> getPairsByGroupId(Long idGroup);

	List<Pair> getPairsByWeek(LocalDateTime startOfWeek, Long idGroup);

	void addGroupsToPair(Long idPair, List<Long> groups);

}
