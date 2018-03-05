package com.senla.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ extends com.senla.entity.Person_ {

	public static volatile ListAttribute<Student, Mark> marks;
	public static volatile SingularAttribute<Student, Group> group;

}

