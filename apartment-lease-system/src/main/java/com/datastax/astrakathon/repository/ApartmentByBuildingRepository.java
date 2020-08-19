package com.datastax.astrakathon.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.datastax.astrakathon.entity.ApartmentByBuilding;
import com.datastax.astrakathon.entity.ApartmentByBuildingKey;

@Repository
public interface ApartmentByBuildingRepository extends CassandraRepository<ApartmentByBuilding, ApartmentByBuildingKey>{
	public ApartmentByBuilding findByKeyBuildingNameAndKeyApartmentName(String buildingName, String apartmentName);
}
