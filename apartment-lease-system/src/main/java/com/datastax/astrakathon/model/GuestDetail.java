package com.datastax.astrakathon.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GuestDetail {
	@JsonProperty
	private String emailAddress;
	@JsonProperty
	private Date createdDate;

	@JsonProperty
	private String firstName;
	@JsonProperty
	private String middleName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private String permanentAddress;
	@JsonProperty
	private String proofOfId;
	@JsonProperty
	private String proofOfIdNumber;
	@JsonProperty
	private String gender;
	@JsonProperty
	private String dateOfBirth;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getProofOfId() {
		return proofOfId;
	}

	public void setProofOfId(String proofOfId) {
		this.proofOfId = proofOfId;
	}

	public String getProofOfIdNumber() {
		return proofOfIdNumber;
	}

	public void setProofOfIdNumber(String proofOfIdNumber) {
		this.proofOfIdNumber = proofOfIdNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
