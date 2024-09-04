package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    // Custom query methods (if needed) can be added here
}
