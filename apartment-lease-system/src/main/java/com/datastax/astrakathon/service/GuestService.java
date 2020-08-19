package com.datastax.astrakathon.service;

import org.springframework.stereotype.Service;

import com.datastax.astrakathon.entity.Guest;
import com.datastax.astrakathon.model.GuestDetail;

@Service
public class GuestService {

	public void createGuestAccount(GuestDetail guestDetail) {
		Guest guest = new Guest(guestDetail);
		
	}

}
