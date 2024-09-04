package com.app.repository;

import com.app.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
	// Additional query methods (if needed) can be defined here
}
