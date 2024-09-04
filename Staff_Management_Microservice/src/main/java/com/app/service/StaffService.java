package com.app.service;

import com.app.dto.StaffDto;

import java.util.List;

public interface StaffService {

	StaffDto createStaff(StaffDto staffDto);

	StaffDto updateStaff(Long staffId, StaffDto staffDto);

	void deleteStaff(Long staffId);

	StaffDto getStaffById(Long staffId);

	List<StaffDto> getAllStaff();
}
