package com.vid.springboot.java.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	@NotNull(message="username should not be null")
	private String name;
	@Email(message="please enter valid email")
	private String email;
	@Pattern(regexp = "^\\d{10}$" ,message="Invalid mobile number ")
	private String mobile;
	@NotNull(message = "please enter age")
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotNull(message="please enter nationality")
	private String nationality;
}
