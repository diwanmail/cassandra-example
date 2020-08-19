package com.datastax.astrakathon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table
@CqlName(GuestLeasingDetail.TABLE_NAME)
public class GuestLeasingDetail implements Serializable {

    /** Serial. */
	private static final long serialVersionUID = -3973526652437357781L;
	
	/** Constants.*/
	public static final String TABLE_NAME = "leasing_detail_by_guest";
	public static final String GUEST_ID = "guest_id";
	public static final String LEASE_ID = "lease_id";
	public static final String APARTMENT_NAME = "apartment_name";
	public static final String LEASE_SIGN_DATE = "lease_sign_date";
	public static final String LEASE_START_DATE = "lease_start_date";
	public static final String LEASE_END_DATE = "lease_end_date";
	public static final String LEASE_DURATION_IN_MONTH = "lease_duration_in_month";
	public static final String LESSOR_NAME = "lessor_name";
	public static final String LEASE_AMOUNT = "lease_amount";
    
    @PartitionKey
    @CqlName(GUEST_ID)
    @JsonProperty(GUEST_ID)
    private String guestId;
    
    @ClusteringColumn
    @CqlName(LEASE_ID)
    private UUID leaseId;
    
    @CqlName(APARTMENT_NAME)
    private String apartmentName;
    
    @CqlName(LEASE_SIGN_DATE)
    @ClusteringColumn
    private Timestamp leaseSignDate;
    
    @CqlName(LEASE_START_DATE)
    private Date leaseStartDate;
    
    @CqlName(LEASE_END_DATE)
    private Date leaseEndDate;
    
    @CqlName(LEASE_DURATION_IN_MONTH)
    private Integer leaseDurationInMonth;
    
    @CqlName(LESSOR_NAME)
    private String lessorName;
    
    @CqlName(LEASE_AMOUNT)
    private BigDecimal leaseAmount;
    
    public GuestLeasingDetail() {}
}