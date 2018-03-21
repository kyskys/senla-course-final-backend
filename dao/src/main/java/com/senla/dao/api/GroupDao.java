package com.senla.dao.api;

import java.util.List;

import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;

public interface GroupDao extends AbstractDao<Group>, Searchable<GroupSearchParams, Group> {

	List<Group> getGroupsByPairId(Long idPair);

	List<Group> getGroupsWithoutPair(Long idPair);
}
