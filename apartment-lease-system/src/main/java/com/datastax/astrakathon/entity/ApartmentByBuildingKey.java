package com.datastax.astrakathon.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class ApartmentByBuildingKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1232793402878865695L;

	@PrimaryKeyColumn(name="building_name", type = PrimaryKeyType.PARTITIONED)
    private String buildingName;
    
    @PrimaryKeyColumn(name="apartment_create_date", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Date apartmentCreationDate;
    
    @PrimaryKeyColumn(name="apartment_name", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private String apartmentName;
    
    public ApartmentByBuildingKey(String apartmentName, String buildingName, Date apartmentCreationDate) {
		this.apartmentName = apartmentName;
		this.buildingName = buildingName;
		this.apartmentCreationDate = apartmentCreationDate;
	}
}
