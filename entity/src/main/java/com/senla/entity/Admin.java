package com.senla.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.senla.entity.util.RoleEnum;

@Entity
@DiscriminatorValue(value = RoleEnum.Values.ADMIN)
public class Admin extends AbstractEntity {

}
