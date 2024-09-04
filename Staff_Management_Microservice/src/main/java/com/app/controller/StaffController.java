package com.app.controller;

import com.app.dto.StaffDto;
import com.app.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing staff members in the system.
 */
@RestController
@RequestMapping("/api/staff")
@Tag(name = "Staff Management", description = "APIs for managing staff members")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     * Creates a new staff member with the provided details.
     *
     * @param staffDto Data transfer object containing staff member details.
     * @return ResponseEntity containing the created StaffDto and HTTP status 201 Created.
     */
    @Operation(summary = "Create a new staff member", description = "Create a new staff member in the system")
    @ApiResponse(responseCode = "201", description = "staff created")
    @PostMapping
    public ResponseEntity<StaffDto> createStaff(@RequestBody StaffDto staffDto) {
        StaffDto createdStaff = staffService.createStaff(staffDto);
        return new ResponseEntity<>(createdStaff, HttpStatus.CREATED);
    }

    /**
     * Retrieves details of a staff member by their unique ID.
     *
     * @param id Unique identifier of the staff member.
     * @return ResponseEntity containing the StaffDto and HTTP status 200 OK.
     */
    @Operation(summary = "Get a staff member by ID", description = "Retrieve details of a staff member by their ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved staff")
    @GetMapping("/{id}")
    public ResponseEntity<StaffDto> getStaffById(@PathVariable("id") Long id) {
        StaffDto staffDto = staffService.getStaffById(id);
        return new ResponseEntity<>(staffDto, HttpStatus.OK);
    }

    /**
     * Retrieves a list of all staff members.
     *
     * @return ResponseEntity containing a list of StaffDto and HTTP status 200 OK.
     */
    @Operation(summary = "Get all staff members", description = "Retrieve a list of all staff members")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaff() {
        List<StaffDto> staffList = staffService.getAllStaff();
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }

    /**
     * Updates the details of an existing staff member.
     *
     * @param id Unique identifier of the staff member to update.
     * @param staffDto Data transfer object containing updated staff member details.
     * @return ResponseEntity containing the updated StaffDto and HTTP status 200 OK.
     */
    @Operation(summary = "Update a staff member", description = "Update details of an existing staff member")
    @ApiResponse(responseCode = "200", description = "staff updated")
    @PutMapping("/{id}")
    public ResponseEntity<StaffDto> updateStaff(
            @PathVariable("id") Long id, 
            @RequestBody StaffDto staffDto) {
        StaffDto updatedStaff = staffService.updateStaff(id, staffDto);
        return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
    }

    /**
     * Deletes a staff member from the system.
     *
     * @param id Unique identifier of the staff member to delete.
     * @return ResponseEntity with no content and HTTP status 204 No Content.
     */
    @Operation(summary = "Delete a staff member", description = "Remove a staff member from the system")
    @ApiResponse(responseCode = "204", description = "staff deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("id") Long id) {
        staffService.deleteStaff(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
