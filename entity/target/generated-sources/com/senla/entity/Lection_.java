package com.senla.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lection.class)
public abstract class Lection_ extends com.senla.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Lection, String> name;
	public static volatile SingularAttribute<Lection, Course> course;
	public static volatile ListAttribute<Lection, Pair> pair;

}

