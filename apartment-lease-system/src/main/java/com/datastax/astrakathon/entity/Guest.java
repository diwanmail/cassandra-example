package com.datastax.astrakathon.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.astrakathon.model.GuestDetail;

@Table(Guest.TABLE_NAME)
public class Guest implements Serializable {

	/** Serial. */
	private static final long serialVersionUID = -3973526652437357781L;

	/** Constants. */
	public static final String TABLE_NAME = "guest_detail";
	public static final String FIRST_NAME = "first_name";
	public static final String MIDDLE_NAME = "middle_name";
	public static final String LAST_NAME = "last_name";
	public static final String PERMANENT_ADDRESS = "permanent_address";
	public static final String PROOF_OF_ID = "proof_of_id";
	public static final String PROOF_OF_ID_NUMBER = "proof_of_id_number";
	public static final String GENDER = "gender";
	public static final String DATE_OF_BIRTH = "date_of_birth";

	@PrimaryKey
	private GuestKey key;

	@Column(FIRST_NAME)
	private String firstName;

	@Column(MIDDLE_NAME)
	private String middleName;

	@Column(LAST_NAME)
	private String lastName;

	@Column(PERMANENT_ADDRESS)
	private String permanentAddress;

	@Column(PROOF_OF_ID)
	private String proofOfId;

	@Column(PROOF_OF_ID_NUMBER)
	private String proofOfIdNumber;

	@Column(GENDER)
	private String gender;

	@Column(DATE_OF_BIRTH)
	private String dateOfBirth;

	public Guest(GuestDetail guestDetail) {
		this.key = new GuestKey(guestDetail.getEmailAddress(), guestDetail.getCreatedDate());
		this.firstName = guestDetail.getFirstName();
		this.middleName = guestDetail.getMiddleName();
		this.lastName = guestDetail.getLastName();
		this.permanentAddress = guestDetail.getPermanentAddress();
		this.proofOfId = guestDetail.getProofOfId();
		this.proofOfIdNumber = guestDetail.getProofOfIdNumber();
		this.gender = guestDetail.getGender();
		this.dateOfBirth = guestDetail.getDateOfBirth();
	}
}
