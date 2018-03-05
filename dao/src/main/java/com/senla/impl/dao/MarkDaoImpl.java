package com.senla.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.senla.api.dao.MarkDao;
import com.senla.dao.search.MarkSearchParams;
import com.senla.dao.search.SortParam;
import com.senla.entity.Mark;
import com.senla.entity.Mark_;
import com.senla.entity.Pair_;
import com.senla.entity.Student_;

@Repository
public class MarkDaoImpl extends SearchableDaoImpl<MarkSearchParams, Mark> implements MarkDao {

	public Class<Mark> getGenericClass() {
		return Mark.class;
	}

	@Override
	protected void initSortMap() {
		sortMap.put(SortParam.ID, Mark_.id);
		sortMap.put(SortParam.PAIR_ID, Mark_.pair);
		sortMap.put(SortParam.STUDENT_ID, Mark_.student);
	}

	@Override
	public void cloneMarkToPair(Long idPair, Long idMark) {
		//TODO sozdat klonirovanie marki
		/*Session session = getSession();
		Query query = session.createQuery("update Mark set pair.id = :idPair where id= :idMark");
		query.setParameter("idPair", idPair);
		query.setParameter("idMark", idMark);
		query.executeUpdate();*/
	}

	@Override
	public void cloneMarkToStudent(Long idStudent, Long idMark) {
		//TODO sozdat klonirovanie marki
		/*Session session = getSession();
		Query query = session.createQuery("update Mark set student.id = :idStudent where id= :idMark");
		query.setParameter("idStudent", idStudent);
		query.setParameter("idMark", idMark);
		query.executeUpdate();*/
	}

	@Override
	protected void applyFilters(MarkSearchParams searchParam, CriteriaQuery<?> query, CriteriaBuilder builder,
			Root<Mark> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchParam.getId() != null) {
			predicates.add(builder.equal(root.get(Mark_.id), searchParam.getId()));
		}
		if (searchParam.getPair() != null) {
			predicates.add(builder.like(root.join(Mark_.pair).get(Pair_.name), like(searchParam.getPair())));
		}
		if (searchParam.getStudent() != null) {
			predicates.add(builder.like(root.join(Mark_.student).get(Student_.name), like(searchParam.getStudent())));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

}
