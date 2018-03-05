package com.senla.api.dao;

import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Pair;

public interface PairDao extends AbstractDao<Pair>, Searchable<PairSearchParams, Pair> {

}
