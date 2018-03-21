package com.senla.entity;

import com.senla.entity.util.RoleEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ extends com.senla.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Person, String> number;
	public static volatile SingularAttribute<Person, String> password;
	public static volatile SingularAttribute<Person, RoleEnum> role;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, String> login;
	public static volatile SingularAttribute<Person, String> email;

}

