package com.demp.app.dto;

import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequest {
	
	@NotNull(message = "Name shouldn't be null/empty")
	private String name;
	
	@Min(18)
	@Max(60)
	private int age;
	
	@Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered")
	private String mobileNo;
	
	@Email(message = "Invalid email address")
	private String email;
	
	private String gender;
	
	@NotBlank
	private String nationality;
}
