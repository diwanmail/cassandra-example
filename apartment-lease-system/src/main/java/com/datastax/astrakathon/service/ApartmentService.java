package com.datastax.astrakathon.service;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.astrakathon.entity.ApartmentByBuilding;
import com.datastax.astrakathon.model.ApartmentBuildingDetail;
import com.datastax.astrakathon.repository.ApartmentByBuildingRepository;

@Service
public class ApartmentService {

	@Autowired
	private ApartmentByBuildingRepository repo;
	
	public void createApartmentInBuilding(String apartmentName, String buildingName,
			ApartmentBuildingDetail apartmentDetails) {
		ApartmentByBuilding apartmentByBuilding = repo.findByKeyBuildingNameAndKeyApartmentName(buildingName, apartmentName);
		
		if(Objects.isNull(apartmentByBuilding)) {
			ApartmentByBuilding apartment = new ApartmentByBuilding(apartmentName, buildingName, apartmentDetails.getApartmentInaugurationDate());
			apartment.setApartmentAddress(apartmentDetails.getApartmentAddress());
			apartment.setApartmentFacting(apartmentDetails.getApartmentFacing());
			apartment.setApartmentType(apartmentDetails.getApartmentType());
			apartment.setBuildingManager(apartmentDetails.getBuildingManager());
			apartment.setBuildingPhone(apartmentDetails.getBuildingPhone());
			apartment.setBathroomCount(apartmentDetails.getBathroomCount());
			apartment.setRoomCount(apartmentDetails.getRoomCount());
			apartment.setApartmentAddress(apartmentDetails.getApartmentAddress());
			apartment.setApartmentAvailable(Boolean.TRUE);
			apartment.setApartmentFacilities(apartmentDetails.getApartmentFacilities());

			repo.save(apartment);
		}
	}

	public void updateApartmentAvailabilityForLease(String apartmentName, String buildingName, Boolean apartmentAvailableForLease) {
		ApartmentByBuilding apartmentByBuilding = repo.findByKeyBuildingNameAndKeyApartmentName(buildingName, apartmentName);
		apartmentByBuilding.setApartmentAvailable(apartmentAvailableForLease);
		
		repo.save(apartmentByBuilding);
	}
	
	public Set<String> listAllApartmentFacilities(String apartmentName, String buildingName) {
		ApartmentByBuilding apartmentByBuilding = repo.findByKeyBuildingNameAndKeyApartmentName(buildingName, apartmentName);
		Set<String> apartmentFacilities = Collections.emptySet();
		if(! Objects.isNull(apartmentByBuilding)) {
			apartmentFacilities = apartmentByBuilding.getApartmentFacilities();
		}
		return apartmentFacilities;
	}

	public Set<String> addNewFacilitiesToApartmentInBuilding(String apartmentName, String buildingName,
			Set<String> newApartmentFacilities) {
		ApartmentByBuilding apartmentByBuilding = repo.findByKeyBuildingNameAndKeyApartmentName(buildingName, apartmentName);
		
		Set<String> apartmentFacilities = apartmentByBuilding.getApartmentFacilities();
		apartmentFacilities.addAll(newApartmentFacilities);
		
		apartmentByBuilding.setApartmentFacilities(apartmentByBuilding.getApartmentFacilities());
		
		repo.save(apartmentByBuilding);
		
		return apartmentByBuilding.getApartmentFacilities();
	}
	
	public Set<String> deleteFacilitiesFromApartmentInBuilding(String apartmentName, String buildingName,
			Set<String> apartmentFacilitiesToDelete) {
		ApartmentByBuilding apartmentByBuilding = repo.findByKeyBuildingNameAndKeyApartmentName(buildingName,
				apartmentName);

		Set<String> apartmentFacilities = apartmentByBuilding.getApartmentFacilities().stream()
				.filter(facility -> !apartmentFacilitiesToDelete.contains(facility)).collect(Collectors.toSet());
		apartmentByBuilding.setApartmentFacilities(apartmentFacilities);

		repo.save(apartmentByBuilding);
		
		return apartmentByBuilding.getApartmentFacilities();
	}
}
