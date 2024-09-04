package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ServiceDto;
import com.app.service.ServiceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controller for managing Service resources.
 * Provides CRUD operations for service resources.
 */
@Tag(name = "Service Resource", description = "CRUD REST APIs for Service Resource")
@RestController
@RequestMapping("/api/services")
@Validated
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    /**
     * Creates a new service with the provided details.
     *
     * @param serviceDto Data transfer object containing service details.
     * @return ResponseEntity containing the created ServiceDto and HTTP status 201 Created.
     */
    @Operation(summary = "Create Service", description = "Create Service API")
    @ApiResponse(responseCode = "201", description = "Service created")
    @PostMapping
    public ResponseEntity<ServiceDto> createService(@Valid @RequestBody ServiceDto serviceDto) {
        ServiceDto createdService = serviceService.createService(serviceDto);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of all services.
     *
     * @return ResponseEntity containing a list of ServiceDto and HTTP status 200 OK.
     */
    @Operation(summary = "Get All Services", description = "Get All Services API")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        List<ServiceDto> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    /**
     * Retrieves a service by its unique ID.
     *
     * @param id Unique identifier of the service.
     * @return ResponseEntity containing the ServiceDto and HTTP status 200 OK.
     */
    @Operation(summary = "Get Service by ID", description = "Get Service by ID API")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved service")
    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable Long id) {
        ServiceDto serviceDto = serviceService.getServiceById(id);
        return ResponseEntity.ok(serviceDto);
    }

    /**
     * Updates the details of an existing service.
     *
     * @param id Unique identifier of the service to be updated.
     * @param serviceDto Data transfer object containing updated service details.
     * @return ResponseEntity containing the updated ServiceDto and HTTP status 200 OK.
     */
    @Operation(summary = "Update Service", description = "Update Service API")
    @ApiResponse(responseCode = "200", description = "Service updated")
    @PutMapping("/{id}")
    public ResponseEntity<ServiceDto> updateService(@PathVariable Long id, @Valid @RequestBody ServiceDto serviceDto) {
        ServiceDto updatedService = serviceService.updateService(id, serviceDto);
        return ResponseEntity.ok(updatedService);
    }

    /**
     * Deletes a service by its unique ID.
     *
     * @param id Unique identifier of the service to be deleted.
     * @return ResponseEntity with no content and HTTP status 204 No Content.
     */
    @Operation(summary = "Delete Service", description = "Delete Service API")
    @ApiResponse(responseCode = "204", description = "Service deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
