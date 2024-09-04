package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ServiceDto;
import com.app.entity.Services;
import com.app.repository.ServiceRepository;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ServiceDto createService(ServiceDto serviceDto) {
		Services services = modelMapper.map(serviceDto, Services.class);
		Services savedService = serviceRepository.save(services);
		return modelMapper.map(savedService, ServiceDto.class);
	}

	@Override
	public ServiceDto updateService(Long serviceId, ServiceDto serviceDto) {
		Services existingService = serviceRepository.findById(serviceId).get();

		existingService.setName(serviceDto.getName());
		existingService.setDetail(serviceDto.getDetail());
		existingService.setPrice(serviceDto.getPrice());
		existingService.setType(serviceDto.getType());

		Services updatedService = serviceRepository.save(existingService);
		return modelMapper.map(updatedService, ServiceDto.class);
	}

	@Override
	public void deleteService(Long serviceId) {
		Services existingService = serviceRepository.findById(serviceId).get();

		serviceRepository.delete(existingService);
	}

	@Override
	public ServiceDto getServiceById(Long serviceId) {
		Services service = serviceRepository.findById(serviceId).get();
		return modelMapper.map(service, ServiceDto.class);
	}

	@Override
	public List<ServiceDto> getAllServices() {
		List<Services> services = serviceRepository.findAll();
		return services.stream().map(service -> modelMapper.map(service, ServiceDto.class))
				.collect(Collectors.toList());
	}
}
