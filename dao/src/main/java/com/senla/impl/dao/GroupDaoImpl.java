package com.senla.impl.dao;

import org.springframework.stereotype.Repository;
import com.senla.api.dao.GroupDao;
import com.senla.entity.Group;

@Repository
public class GroupDaoImpl extends AbstractDaoImpl<Group> implements GroupDao {

	public Class<Group> getGenericClass() {
		return Group.class;
	}

}
