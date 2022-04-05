package com.demp.app.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER_TBL")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "username")
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private String gender;

	@Column(name = "nationality")
	private String nationality;

	private User() {
	}

	public User(int id, String name, int age, String mobileNo, String email, String gender, String nationality) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
		this.gender = gender;
		this.nationality = nationality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", mobileNo=" + mobileNo + ", email=" + email + ", gender="
				+ gender + ", nationality=" + nationality + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, gender, id, mobileNo, name, nationality);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(email, other.email) && Objects.equals(gender, other.gender)
				&& id == other.id && Objects.equals(mobileNo, other.mobileNo) && Objects.equals(name, other.name)
				&& Objects.equals(nationality, other.nationality);
	}

}
