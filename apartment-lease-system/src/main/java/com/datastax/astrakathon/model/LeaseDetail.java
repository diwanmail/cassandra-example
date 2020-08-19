package com.datastax.astrakathon.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeaseDetail {
	@JsonProperty
	private String apartmentName;
	@JsonProperty private Date leaseSignDate;
	@JsonProperty private Date leaseStartDate;
	@JsonProperty private Date leaseEndDate;
	@JsonProperty private Integer leaseDurationInMonth;
	@JsonProperty private String guestEmailAddress;
	@JsonProperty private String lessor;
	@JsonProperty private BigDecimal leaseAmount;
	@JsonProperty private Boolean isLeaseActive;

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public Date getLeaseSignDate() {
		return leaseSignDate;
	}

	public void setLeaseSignDate(Date leaseSignDate) {
		this.leaseSignDate = leaseSignDate;
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
