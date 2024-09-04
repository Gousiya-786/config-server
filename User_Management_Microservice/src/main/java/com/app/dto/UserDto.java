package com.app.dto;

import com.app.entity.Gender;
import com.app.entity.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "UserDto model information")
public class UserDto {

	@Schema(description = "Unique identifier of the user", example = "1")
	private Long id;

	@Schema(description = "Name of the user", example = "John Doe")
	private String name;

	@Schema(description = "Email address of the user", example = "john.doe@example.com")
	private String email;

	@Schema(description = "Mobile number of the user", example = "+1234567890")
	private String mobileNo;
	
	@Schema(description = "Password of the user", example = "123456789")
	private String password;

	@Schema(description = "Gender of the user", example = "Male")
	private Gender gender;

	@Schema(description = "Role assigned to the user", example = "ADMIN")
	private Role role;
}
