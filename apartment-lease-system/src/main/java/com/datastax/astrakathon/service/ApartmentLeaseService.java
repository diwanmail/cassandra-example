package com.datastax.astrakathon.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.astrakathon.entity.LeaseDetailByApartment;
import com.datastax.astrakathon.model.LeaseDetail;
import com.datastax.astrakathon.repository.LeaseDetailByApartmentRepository;

@Service
public class ApartmentLeaseService {

	@Autowired
	private LeaseDetailByApartmentRepository repo;

	/*
	 * Create or renew lease aggreement between Guest and Lessor for a apartment. 1). Check
	 * if any active lease present then first make them all Inactive 2). Create
	 * lease and save.
	 */
	public LeaseDetailByApartment createOrRenewLeaseForApartment(String apartmentName, LeaseDetail leaseDetail) {
		List<LeaseDetailByApartment> activeLeases = repo.findByKeyApartmentName(apartmentName);
		if (CollectionUtils.isNotEmpty(activeLeases)) {
			activeLeases.stream().forEach(activeLease -> activeLease.setIsLeaseActive(Boolean.FALSE));
			repo.saveAll(activeLeases);
		}

		LeaseDetailByApartment lease = new LeaseDetailByApartment(apartmentName, leaseDetail);
		return repo.save(lease);
	}

	/*
	 * End Lease agreement for a partment before end date.
	 */
	public void endLeaseBeforeLeaseEndDateForApartment(String apartmentName, Date leaseEndDate) {
		/*
		 * List<LeaseDetailByApartment> activeLeases =
		 * repo.findByKeyApartmentNameAndIsLeaseActive(apartmentName, Boolean.TRUE); if
		 * (CollectionUtils.isNotEmpty(activeLeases)) {
		 * activeLeases.stream().forEach(activeLease -> {
		 * activeLease.setIsLeaseActive(Boolean.FALSE);
		 * activeLease.setLeaseEndDate(leaseEndDate); }); repo.saveAll(activeLeases); }
		 */}

	/*
	 * Transfer lease from one party to other party.
	 */
	public void trasnferLeaseForApartment(String apartmentName, String newGuestEmailAddress, String existingGuestName) {
		LeaseDetailByApartment activeLease = repo.findByKeyApartmentNameAndGuestEmailAddressAndIsLeaseActive(apartmentName,
				existingGuestName, Boolean.TRUE);
		
		activeLease.setGuestEmailAddress(newGuestEmailAddress);
		
		repo.save(activeLease);
	}
	
	/*
	 * Find all lease done for apartment.
	 */
	public List<LeaseDetailByApartment> findAllLeaseDoneForApartment(String apartmentName) {
		return repo.findAllByKeyApartmentName(apartmentName);
	}
}