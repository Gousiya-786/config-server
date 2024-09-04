package com.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "ServiceDto model information")
public class ServiceDto {

    @Schema(description = "Unique identifier of the service", example = "1")
    private Long id;

    @Schema(description = "Name of the service", example = "Haircut")
    private String name;

    @Schema(description = "Detailed description of the service", example = "A professional haircut service")
    private String detail;

    @Schema(description = "Price of the service", example = "25.50")
    private Double price;

    @Schema(description = "Type or category of the service", example = "Grooming")
    private String type;
}
