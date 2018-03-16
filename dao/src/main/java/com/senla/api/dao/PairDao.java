package com.senla.api.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;
import com.senla.entity.Pair;

public interface PairDao extends AbstractDao<Pair>, Searchable<PairSearchParams, Pair> {

	List<Pair> getPairsByGroupId(Long idGroup);

	List<Pair> getPairsByWeek(LocalDateTime startOfWeek, Long idGroup);

}
