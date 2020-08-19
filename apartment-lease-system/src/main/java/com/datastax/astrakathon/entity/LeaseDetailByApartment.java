package com.datastax.astrakathon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.astrakathon.model.LeaseDetail;
import com.datastax.oss.driver.api.core.uuid.Uuids;

@Table(LeaseDetailByApartment.TABLE_NAME)
public class LeaseDetailByApartment implements Serializable {

    /** Serial. */
	private static final long serialVersionUID = -3973526652437357781L;
	
	/** Constants.*/
	public static final String TABLE_NAME = "leasing_detail_by_apartment";
	public static final String APARTMENT_NAME = "apartment_name";
	public static final String LEASE_ID = "lease_id";
	public static final String LEASE_START_DATE = "lease_start_date";
	public static final String LEASE_END_DATE = "lease_end_date";
	public static final String LEASE_DURATION_IN_MONTH = "lease_duration_in_month";
	public static final String GUEST_EMAIL_ADDRESS = "guest_email_address";
	public static final String LESSOR_NAME = "lessor_name";
	public static final String LEASE_SIGN_DATE = "lease_sign_date";
	public static final String LEASE_AMOUNT = "lease_amount";
	private static final String IS_LEASE_ACTIVE = "is_lease_active";
    
    @PrimaryKey
    private LeaseDetailByApartmentKey key; 
    
    @Column(LEASE_ID)
    private UUID leaseId;
    
    @Column(LEASE_START_DATE)
    private Date leaseStartDate;
    
    @Column(LEASE_END_DATE)
    private Date leaseEndDate;
    
    @Column(LEASE_DURATION_IN_MONTH)
    private Integer leaseDurationInMonth;
    
    @Column(GUEST_EMAIL_ADDRESS)
    private String guestEmailAddress;
    
    @Column(LESSOR_NAME)
    private String lessor;
    
    @Column(LEASE_AMOUNT)
    private BigDecimal leaseAmount;
    
    @Column(IS_LEASE_ACTIVE)
    private Boolean isLeaseActive;
    
    public LeaseDetailByApartment() {}
    
    public LeaseDetailByApartment(String apartmentName, LeaseDetail leaseDetail) {
    	this.key = new LeaseDetailByApartmentKey(apartmentName, leaseDetail.getLeaseSignDate());
    	this.leaseId = Uuids.random();
    	this.leaseStartDate = leaseDetail.getLeaseStartDate();
    	this.leaseEndDate = leaseDetail.getLeaseEndDate();
    	this.leaseDurationInMonth = leaseDetail.getLeaseDurationInMonth();
    	this.guestEmailAddress = leaseDetail.getGuestEmailAddress();
    	this.lessor = leaseDetail.getLessor();
    	this.leaseAmount = leaseDetail.getLeaseAmount();
    	this.isLeaseActive = Boolean.TRUE;
    }

	public LeaseDetailByApartmentKey getKey() {
		return key;
	}

	public void setKey(LeaseDetailByApartmentKey key) {
		this.key = key;
	}

	public UUID getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(UUID leaseId) {
		this.leaseId = leaseId;
	}

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public Date getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public Integer getLeaseDurationInMonth() {
		return leaseDurationInMonth;
	}

	public void setLeaseDurationInMonth(Integer leaseDurationInMonth) {
		this.leaseDurationInMonth = leaseDurationInMonth;
	}

	public String getGuestEmailAddress() {
		return guestEmailAddress;
	}

	public void setGuestEmailAddress(String guestEmailAddress) {
		this.guestEmailAddress = guestEmailAddress;
	}

	public String getLessor() {
		return lessor;
	}

	public void setLessor(String lessor) {
		this.lessor = lessor;
	}

	public BigDecimal getLeaseAmount() {
		return leaseAmount;
	}

	public void setLeaseAmount(BigDecimal leaseAmount) {
		this.leaseAmount = leaseAmount;
	}

	public Boolean getIsLeaseActive() {
		return isLeaseActive;
	}

	public void setIsLeaseActive(Boolean isLeaseActive) {
		this.isLeaseActive = isLeaseActive;
	}
}