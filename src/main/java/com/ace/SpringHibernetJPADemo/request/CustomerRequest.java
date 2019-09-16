package com.ace.SpringHibernetJPADemo.request;

public class CustomerRequest {

	private String custName;
	private String mobileNumber;
	private String emailAddress;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "CustomerRequest [custName=" + custName + ", mobileNumber=" + mobileNumber + ", emailAddress="
				+ emailAddress + "]";
	}

	
}
