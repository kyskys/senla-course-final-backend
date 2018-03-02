package com.senla.impl.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import com.senla.api.dao.StudentDao;
import com.senla.dao.search.SortParam;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Student;

@Repository
public class StudentDaoImpl extends SearchableDaoImpl<StudentSearchParams, Student> implements StudentDao {

	private static final String SORT_PARAM_ID = "id";
	private static final String SORT_PARAM_NAME = "name";
	private static final String SORT_PARAM_EMAIL = "email";
	private static final String SORT_PARAM_PHONE_NUMBER = "number";
	private static final String SORT_PARAM_GROUP_ID = "group";

	public Class<Student> getGenericClass() {
		return Student.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, SORT_PARAM_ID);
		sortMap.put(SortParam.NAME, SORT_PARAM_NAME);
		sortMap.put(SortParam.EMAIL, SORT_PARAM_EMAIL);
		sortMap.put(SortParam.PHONE_NUMBER, SORT_PARAM_PHONE_NUMBER);
		sortMap.put(SortParam.GROUP_ID, SORT_PARAM_GROUP_ID);
	}

	@Override
	protected void applyFilters(StudentSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Student> root) {
		if (searchParam.getId() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_ID), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			query.where(builder.like(root.get(SORT_PARAM_NAME), like(searchParam.getName())));
		}
		if (searchParam.getEmail() != null) {
			query.where(builder.like(root.get(SORT_PARAM_EMAIL), like(searchParam.getEmail())));
		}
		if (searchParam.getNumber() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_PHONE_NUMBER), searchParam.getNumber()));
		}
		if (searchParam.getGroup() != null) {
			query.where(builder.equal(root.get(SORT_PARAM_GROUP_ID), searchParam.getGroup()));
		}
	}


}
