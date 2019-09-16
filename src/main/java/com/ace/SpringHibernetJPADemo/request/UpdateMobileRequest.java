package com.ace.SpringHibernetJPADemo.request;

public class UpdateMobileRequest {
	
	private String mobile;
	
	private String customerId;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
