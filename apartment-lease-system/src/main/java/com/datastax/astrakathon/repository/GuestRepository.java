package com.datastax.astrakathon.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.datastax.astrakathon.entity.Guest;
import com.datastax.astrakathon.entity.GuestKey;

@Repository
public interface GuestRepository extends CassandraRepository<Guest, GuestKey>{
	public Guest findByKeyEmailAddress(String emailAddress);
}
