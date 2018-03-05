package com.senla.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ extends com.senla.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Course, String> name;
	public static volatile SingularAttribute<Course, Lecturer> lecturer;
	public static volatile SingularAttribute<Course, String> description;
	public static volatile ListAttribute<Course, Lection> lections;

}

