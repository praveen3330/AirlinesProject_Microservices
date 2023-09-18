package com.emirates.enrollment.model;

import lombok.Data;

/**
 * 
 * @author Praveen by 12-Jun-2023
 * Description :
 *
 */
@Data
public class EnrollmentRequest {

	private String firstname;
	private String middleName;
	private String lastName;
	private String title;
	private String gender;
	private String dob;
	private String emailid;
	private String homeaddress;
	private String residencyaddress; 
	private String state;
	private String city;
	private String pincode;
	private String country;
	private String mobilenum;
}
