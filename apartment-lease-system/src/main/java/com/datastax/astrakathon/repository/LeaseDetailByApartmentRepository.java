package com.datastax.astrakathon.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.datastax.astrakathon.entity.LeaseDetailByApartment;
import com.datastax.astrakathon.entity.LeaseDetailByApartmentKey;

@Repository
public interface LeaseDetailByApartmentRepository extends CassandraRepository<LeaseDetailByApartment, LeaseDetailByApartmentKey>{
	public List<LeaseDetailByApartment> findAllByKeyApartmentName(String apartmentName);
	
	public List<LeaseDetailByApartment> findByKeyApartmentName(String apartmentName);
	
	public LeaseDetailByApartment findByKeyApartmentNameAndGuestEmailAddressAndIsLeaseActive(String apartmentName, String guestEmailAddress, Boolean isLeaseActive);
}
