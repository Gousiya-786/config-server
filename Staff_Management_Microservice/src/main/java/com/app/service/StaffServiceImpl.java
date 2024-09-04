package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StaffDto;
import com.app.entity.Staff;
import com.app.repository.StaffRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StaffDto createStaff(StaffDto staffDto) {
        Staff staff = modelMapper.map(staffDto, Staff.class);
        Staff savedStaff = staffRepository.save(staff);
        return modelMapper.map(savedStaff, StaffDto.class);
    }

    @Override
    public StaffDto updateStaff(Long staffId, StaffDto staffDto) {
        Staff existingStaff = staffRepository.findById(staffId).orElseThrow();
        modelMapper.map(staffDto, existingStaff);
        Staff updatedStaff = staffRepository.save(existingStaff);
        return modelMapper.map(updatedStaff, StaffDto.class);
    }

    @Override
    public void deleteStaff(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public StaffDto getStaffById(Long staffId) {
        Staff staff = staffRepository.findById(staffId).orElseThrow();
        return modelMapper.map(staff, StaffDto.class);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream()
                        .map(staff -> modelMapper.map(staff, StaffDto.class))
                        .collect(Collectors.toList());
    }
}