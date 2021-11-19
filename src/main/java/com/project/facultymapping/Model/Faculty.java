package com.project.facultymapping.Model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="faculty_details")
public class Faculty {
	
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name="name")
private String Name;

@Column(name="dob")
private String DOB;

@Column(name="dept")
private String Dept;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getDOB() {
	return DOB;
}

public void setDOB(String dOB) {
	DOB = dOB;
}

public String getDept() {
	return Dept;
}

public void setDept(String dept) {
	Dept = dept;
}

public String getGender() {
	return Gender;
}

public void setGender(String gender) {
	Gender = gender;
}

public String getEmail_id() {
	return Email_id;
}

public void setEmail_id(String email_id) {
	Email_id = email_id;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public Faculty(String name, String dOB, String dept, String gender, String email_id, String password) {
	super();
	Name = name;
	DOB = dOB;
	Dept = dept;
	Gender = gender;
	Email_id = email_id;
	Password = password;
}

@Column(name="gender")
private String Gender;

@Column(name="email_id")
private String Email_id;

@Column(name="password")
private String Password;

}