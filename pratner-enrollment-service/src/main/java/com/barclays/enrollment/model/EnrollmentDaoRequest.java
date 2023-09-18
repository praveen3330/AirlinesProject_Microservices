package com.barclays.enrollment.model;

import lombok.Data;

@Data
public class EnrollmentDaoRequest {

	private int custid;
	private String firstname;
	private String middleName;
	private String lastName;
	private String title;
	private String gender;
	private String dob;
	private String emailid;
	private Address address;
	private String state;
	private String city;
	private String pincode;
	private String country;
	private Long mobilenum;
	private String ffnumber;
	
	
}