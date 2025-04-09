package com.crud.FlutterBackendCrud.test;

public class Model {
	
	private String userName;
	private String emailId;
	private String mobileNumber;
	
	
	public Model() {
		super();
	}


	public Model(String userName, String emailId, String mobileNumber) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
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
	public String toString() {
		return "Model [userName=" + userName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
