package com.senla.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import com.senla.api.dao.StudentDao;
import com.senla.dao.search.SortParam;
import com.senla.dao.search.StudentSearchParams;
import com.senla.entity.Group_;
import com.senla.entity.Student;
import com.senla.entity.Student_;

@Repository
public class StudentDaoImpl extends SearchableDaoImpl<StudentSearchParams, Student> implements StudentDao {

	public Class<Student> getGenericClass() {
		return Student.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Student_.id);
		sortMap.put(SortParam.NAME, Student_.name);
		sortMap.put(SortParam.EMAIL, Student_.email);
		sortMap.put(SortParam.PHONE_NUMBER, Student_.number);
		sortMap.put(SortParam.GROUP_ID, Student_.group);
	}

	@Override
	protected void applyFilters(StudentSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Student> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Student_.id), searchParam.getId()));
		}
		if (searchParam.getName() != null) {
			predicates.add(builder.like(root.get(Student_.name), like(searchParam.getName())));
		}
		if (searchParam.getEmail() != null) {
			predicates.add(builder.like(root.get(Student_.email), like(searchParam.getEmail())));
		}
		if (searchParam.getNumber() != null) {
			predicates.add(builder.equal(root.get(Student_.number), searchParam.getNumber()));
		}
		if (searchParam.getGroup() != null) {
			predicates.add(builder.like(root.join(Student_.group).get(Group_.name), like(searchParam.getGroup())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}
}
