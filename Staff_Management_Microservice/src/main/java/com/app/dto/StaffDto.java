package com.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import com.app.entity.Gender;

@Data
@Schema(description = "StaffDto model information")
public class StaffDto {

	@Schema(description = "Unique identifier for the staff member", example = "1")
	private Long id;

	@Schema(description = "Name of the staff member", example = "John Doe")
	private String name;

	@Schema(description = "Details about the staff member", example = "Senior stylist with 10 years of experience")
	private String details;


	@Schema(description = "Gender of the staff member", example = "MALE")
	private Gender gender;

	
}
