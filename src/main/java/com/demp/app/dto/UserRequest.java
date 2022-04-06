package com.demp.app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class UserRequest {

	@NotNull(message = "Name shouldn't be null/empty")
	private String name;

	@Min(18)
	@Max(60)
	private int age;

	@Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered")
	private String mobileNo;

	@Email(message = "Invalid email address")
	@Column(unique = true)
	private String email;

   	private String gender;

	@NotBlank
	private String nationality;

	public UserRequest() {
	}

	public UserRequest(@NotNull(message = "Name shouldn't be null/empty") String name, @Min(18) @Max(60) int age,
			@Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered") String mobileNo,
			@Email(message = "Invalid email address") String email, String gender, @NotBlank String nationality) {
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.email = email;
		this.gender = gender;
		this.nationality = nationality;
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
		return "UserRequest [name=" + name + ", age=" + age + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", gender=" + gender + ", nationality=" + nationality + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, gender, mobileNo, name, nationality);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRequest other = (UserRequest) obj;
		return age == other.age && Objects.equals(email, other.email) && Objects.equals(gender, other.gender)
				&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(name, other.name)
				&& Objects.equals(nationality, other.nationality);
	}
}
