package com.senla.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pair.class)
public abstract class Pair_ extends com.senla.entity.AbstractEntity_ {

	public static volatile SingularAttribute<Pair, LocalDateTime> date;
	public static volatile SingularAttribute<Pair, String> name;
	public static volatile ListAttribute<Pair, Group> groups;
	public static volatile SingularAttribute<Pair, PairTime> time;
	public static volatile ListAttribute<Pair, Mark> marks;
	public static volatile SingularAttribute<Pair, Lection> lection;

}

