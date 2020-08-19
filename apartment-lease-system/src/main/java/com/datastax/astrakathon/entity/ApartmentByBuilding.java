package com.datastax.astrakathon.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(ApartmentByBuilding.TABLE_NAME)
public class ApartmentByBuilding implements Serializable {

	/** Serial. */
	private static final long serialVersionUID = -3973526652437357781L;

	/** Constants. */
	public static final String TABLE_NAME = "apartments_by_buildling";
	public static final String BUILDING_NAME = "building_name";
	public static final String APARTMENT_INAUGURATION_DATE = "apartment_inauguration_date";
	public static final String APARTMENT_NAME = "apartment_name";
	public static final String APARTMENT_ADDRESS = "apartment_address";
	public static final String APARTMENT_TYPE = "apartment_type";
	public static final String BUILDING_MANAGER = "building_manager";
	public static final String BUILDING_PHONE = "building_phone";
	public static final String ROOM_COUNT = "room_count";
	public static final String BATHROOM_COUNT = "bathroom_count";
	public static final String APARTMENT_FACING = "appartment_facing";
	public static final String APARTMENT_FACILITIES = "appartment_facilities";
	public static final String IS_APARTMENT_AVAILABLE_FOR_LEASE = "is_apartment_available_for_lease";

	@PrimaryKey
	private ApartmentByBuildingKey key;

	@Column(APARTMENT_ADDRESS)
	private String apartmentAddress;

	@Column(APARTMENT_TYPE)
	private String apartmentType;

	@Column(ROOM_COUNT)
	private Integer roomCount;

	@Column(BATHROOM_COUNT)
	private Integer bathroomCount;

	@Column(APARTMENT_FACING)
	private String apartmentFacing;

	@Column(APARTMENT_FACILITIES)
	private Set<String> apartmentFacilities;

	@Column(IS_APARTMENT_AVAILABLE_FOR_LEASE)
	private Boolean apartmentAvailable;

	@Column(BUILDING_MANAGER)
	private String buildingManager;

	@Column(BUILDING_PHONE)
	private String buildingPhone;

	public ApartmentByBuilding() {}
	
	public ApartmentByBuilding(String apartmentName, String buildingName, Date apartmentCreationDate) {
    	this.key = new ApartmentByBuildingKey(apartmentName, buildingName, apartmentCreationDate);
    }

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

	public String getApartmentFacing() {
		return apartmentFacing;
	}

	public void setApartmentFacting(String apartmentFacing) {
		this.apartmentFacing = apartmentFacing;
	}

	public Set<String> getApartmentFacilities() {
		return apartmentFacilities;
	}

	public void setApartmentFacilities(Set<String> apartmentFacilities) {
		this.apartmentFacilities = apartmentFacilities;
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

	public ApartmentByBuildingKey getKey() {
		return key;
	}

	public void setKey(ApartmentByBuildingKey key) {
		this.key = key;
	}

	public Boolean getApartmentAvailable() {
		return apartmentAvailable;
	}

	public void setApartmentAvailable(Boolean apartmentAvailable) {
		this.apartmentAvailable = apartmentAvailable;
	}
}