package com.senla.api.service;

import com.senla.dao.search.PairSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Pair;

public interface PairService extends AbstractService<Pair>, Searchable<PairSearchParams, Pair> {

}
