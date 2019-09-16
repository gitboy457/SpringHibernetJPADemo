package com.ace.SpringHibernetJPADemo.exception;

import java.util.Date;
import java.util.List;

public class ErrorResponse {
	
 
    //General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;
    
    
    private Date currentDate;
    
    private int statusCode;
    
   


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<String> getDetails() {
		return details;
	}


	public void setDetails(List<String> details) {
		this.details = details;
	}


	public Date getCurrentDate() {
		return currentDate;
	}


	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
    
    
}
