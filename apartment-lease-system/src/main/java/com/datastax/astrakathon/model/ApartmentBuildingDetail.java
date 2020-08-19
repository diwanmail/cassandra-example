package com.datastax.astrakathon.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApartmentBuildingDetail {

	private String apartmentAddress;

	private String apartmentType;

	private String apartmentFacing;

	private Boolean apartmentAvailable;

	private String buildingManager;

	private String buildingPhone;

	private Integer roomCount;

	private Integer bathroomCount;
	
	private Set<String> apartmentFacilities;
	
	@JsonFormat(pattern = "yyyy-mm-dd", timezone = "America/Los_Angeles")
	private Date apartmentInaugurationDate;

	public String getApartmentAddress() {
		return apartmentAddress;
	}

	public void setApartmentAddress(String apartmentAddress) {
		this.apartmentAddress = apartmentAddress;
	}

	public String getApartmentType() {
		return apartmentType;
	}

	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}

	public String getApartmentFacing() {
		return apartmentFacing;
	}

	public void setApartmentFacing(String apartmentFacing) {
		this.apartmentFacing = apartmentFacing;
	}

	public Boolean getApartmentAvailable() {
		return apartmentAvailable;
	}

	public void setApartmentAvailable(Boolean apartmentAvailable) {
		this.apartmentAvailable = apartmentAvailable;
	}

	public String getBuildingManager() {
		return buildingManager;
	}

	public void setBuildingManager(String buildingManager) {
		this.buildingManager = buildingManager;
	}

	public String getBuildingPhone() {
		return buildingPhone;
	}

	public void setBuildingPhone(String buildingPhone) {
		this.buildingPhone = buildingPhone;
	}

	public Integer getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}

	public Integer getBathroomCount() {
		return bathroomCount;
	}

	public void setBathroomCount(Integer bathroomCount) {
		this.bathroomCount = bathroomCount;
	}

	public Date getApartmentInaugurationDate() {
		return apartmentInaugurationDate;
	}

	public void setApartmentInaugurationDate(Date apartmentInaugurationDate) {
		this.apartmentInaugurationDate = apartmentInaugurationDate;
	}

	public Set<String> getApartmentFacilities() {
		return apartmentFacilities;
	}

	public void setApartmentFacilities(Set<String> apartmentFacilities) {
		this.apartmentFacilities = apartmentFacilities;
	}

}
