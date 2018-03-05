package com.senla.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Group.class)
public abstract class Group_ extends com.senla.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Group, String> name;
	public static volatile ListAttribute<Group, Student> students;
	public static volatile ListAttribute<Group, Pair> pairs;

}

