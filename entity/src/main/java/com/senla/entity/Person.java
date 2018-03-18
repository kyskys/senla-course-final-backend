package com.senla.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import com.senla.entity.util.RoleEnum;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@SecondaryTables(value = { @SecondaryTable(name = "user_details"), @SecondaryTable(name = "user_creds") })
public class Person extends AbstractEntity {

	@Column(name = "name")
	protected String name;

	@Column(name = "email", table = "user_details")
	protected String email;

	@Column(name = "role", insertable = false, updatable = false)
	@Enumerated(value = EnumType.STRING)
	protected RoleEnum role;

	@Column(name = "phone_number", table = "user_details")
	protected String number;

	@Column(name = "login", table = "user_creds")
	protected String login;

	@Column(name = "password", table = "user_creds")
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
}
