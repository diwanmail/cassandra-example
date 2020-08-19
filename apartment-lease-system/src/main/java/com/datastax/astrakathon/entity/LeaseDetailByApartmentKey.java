package com.datastax.astrakathon.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class LeaseDetailByApartmentKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1232793402878865695L;

	@PrimaryKeyColumn(name="apartment_name", type = PrimaryKeyType.PARTITIONED)
    private String apartmentName;
    
    @PrimaryKeyColumn(name="lease_sign_date", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Date leaseSignDate;
    
    public LeaseDetailByApartmentKey(String apartmentName, Date leaseSignDate) {
		this.apartmentName = apartmentName;
		this.leaseSignDate = leaseSignDate;
	}
}
