/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.model;

import lombok.Data;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Data
public class EnrollmentRequest {

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
}
