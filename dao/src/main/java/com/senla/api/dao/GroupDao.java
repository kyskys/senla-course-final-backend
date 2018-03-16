package com.senla.api.dao;

import java.util.List;

import com.senla.dao.search.GroupSearchParams;
import com.senla.dao.search.Searchable;
import com.senla.entity.Group;
import com.senla.entity.Pair;
import com.senla.entity.Student;

public interface GroupDao extends AbstractDao<Group>, Searchable<GroupSearchParams, Group> {

	List<Group> getGroupsByPairId(Long idPair);

	List<Group> getGroupsWithoutPair(Long idPair);
}
