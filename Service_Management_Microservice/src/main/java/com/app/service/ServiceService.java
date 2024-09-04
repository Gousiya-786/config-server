package com.app.service;

import java.util.List;

import com.app.dto.ServiceDto;

public interface ServiceService {
	ServiceDto createService(ServiceDto serviceDto);

	ServiceDto updateService(Long serviceId, ServiceDto serviceDto);

	void deleteService(Long serviceId);

	ServiceDto getServiceById(Long serviceId);

	List<ServiceDto> getAllServices();
}
