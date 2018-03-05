package com.senla.entity;

import com.senla.entity.util.RoleEnum;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.senla.entity.AbstractEntity_ {

	public static volatile SingularAttribute<User, Integer> number;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, RoleEnum> role;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> email;

}

