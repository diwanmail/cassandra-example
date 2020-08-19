package com.datastax.astrakathon.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class GuestKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1232793402878865695L;

	@PrimaryKeyColumn(name = "email_address", type = PrimaryKeyType.PARTITIONED)
	private String emailAddress;

	@PrimaryKeyColumn(name = "created_date", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private Date createdDate;

	public GuestKey(String emailAddress, Date createdDate) {
		this.emailAddress = emailAddress;
		this.createdDate = createdDate;
	}
}
