package com.crud.FlutterBackendCrud.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_app_test")
public class MyAppTestEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	

	public MyAppTestEntity() {
		super();
	}

	public MyAppTestEntity(int id, String userName, String emailId, String mobileNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}

	public MyAppTestEntity(String userName, String emailId, String mobileNumber) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + id;
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAppTestEntity other = (MyAppTestEntity) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (id != other.id)
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyAppTestEntity [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	

}
