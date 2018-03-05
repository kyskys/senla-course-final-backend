package com.senla.entity;

import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PairTime.class)
public abstract class PairTime_ extends com.senla.entity.AbstractEntity_ {

	public static volatile SingularAttribute<PairTime, LocalTime> startTime;
	public static volatile SingularAttribute<PairTime, LocalTime> endTime;

}

