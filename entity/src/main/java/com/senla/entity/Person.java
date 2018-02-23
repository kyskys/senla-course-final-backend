package com.senla.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@SecondaryTables(value = { 
		@SecondaryTable(name = "person_details"), 
		@SecondaryTable(name = "person_creds") })
public abstract class Person extends AbstractEntity {

	@Column(name = "name")
	protected String name;

	@Column(name = "email", table = "person_details")
	protected String email;

	@Column(name = "phone_number", table = "person_details")
	protected Integer number;

	@Column(name = "login", table = "person_creds")
	protected String login;

	@Column(name = "password", table = "person_creds")
	protected String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
