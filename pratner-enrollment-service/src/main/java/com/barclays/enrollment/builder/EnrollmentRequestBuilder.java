/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.builder;

import org.springframework.stereotype.Component;

import com.barclays.enrollment.model.Address;
import com.barclays.enrollment.model.EmiratesServiceRequest;
import com.barclays.enrollment.model.EmiratesServiceResponse;
import com.barclays.enrollment.model.EnrollmentDaoRequest;
import com.barclays.enrollment.model.EnrollmentRequest;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Component
public class EnrollmentRequestBuilder {
	
	/**
	 * Description : build the address object
	 * @param enrollmentRequest
	 * @return
	 */
	private Address buildAddress(EnrollmentRequest enrollmentRequest) {
		Address address =new Address() ;
		address.setHomeaddress(enrollmentRequest.getAddress().getHomeaddress());
		address.setResidencyaddress(enrollmentRequest.getAddress().getResidencyaddress());
		return address;
	}

	/**
	 * 
	 * Description : Prepare the emirates service client request
	 * @param enrollmentRequest
	 * @return
	 */
	public EmiratesServiceRequest buildEmiratesRequest(EnrollmentRequest enrollmentRequest) {
		
		EmiratesServiceRequest emiratesServiceRequest = new EmiratesServiceRequest();
		
		Address address = buildAddress(enrollmentRequest);
		
		emiratesServiceRequest.setAddress(address );
		emiratesServiceRequest.setCity(enrollmentRequest.getCity());
		emiratesServiceRequest.setCountry(enrollmentRequest.getCountry());
		emiratesServiceRequest.setDob(enrollmentRequest.getDob());
		emiratesServiceRequest.setEmailid(enrollmentRequest.getEmailid());
		emiratesServiceRequest.setFirstname(enrollmentRequest.getFirstname());
		emiratesServiceRequest.setGender(enrollmentRequest.getGender());
		emiratesServiceRequest.setLastName(enrollmentRequest.getLastName());
		emiratesServiceRequest.setMiddleName(enrollmentRequest.getMiddleName());
		emiratesServiceRequest.setMobilenum(enrollmentRequest.getMobilenum());
		emiratesServiceRequest.setPincode(enrollmentRequest.getPincode());
		emiratesServiceRequest.setState(enrollmentRequest.getState());
		emiratesServiceRequest.setTitle(enrollmentRequest.getTitle());
		
		return emiratesServiceRequest;
	}

	/**
	 * 
	 * Description : This method is used to prepare dao request with the help of EnrollmentRequest
	 * @param enrollmentRequest
	 * @return
	 */
	public EnrollmentDaoRequest buildDaoRequest(EnrollmentRequest enrollmentRequest, EmiratesServiceResponse emiratesServiceResponse) {
		
        EnrollmentDaoRequest enrollmentDaoRequest = new EnrollmentDaoRequest();
 
        enrollmentDaoRequest.setCustid(enrollmentRequest.getCustid());
        
        Address address = buildAddress(enrollmentRequest);
		
		enrollmentDaoRequest.setAddress(address);
		enrollmentDaoRequest.setCity(enrollmentRequest.getCity());
		enrollmentDaoRequest.setCountry(enrollmentRequest.getCountry());
		enrollmentDaoRequest.setDob(enrollmentRequest.getDob());
		enrollmentDaoRequest.setEmailid(enrollmentRequest.getEmailid());
		enrollmentDaoRequest.setFirstname(enrollmentRequest.getFirstname());
		enrollmentDaoRequest.setGender(enrollmentRequest.getGender());
		enrollmentDaoRequest.setLastName(enrollmentRequest.getLastName());
		enrollmentDaoRequest.setMiddleName(enrollmentRequest.getMiddleName());
		enrollmentDaoRequest.setMobilenum(enrollmentRequest.getMobilenum());
		enrollmentDaoRequest.setPincode(enrollmentRequest.getPincode());
		enrollmentDaoRequest.setState(enrollmentRequest.getState());
		enrollmentDaoRequest.setTitle(enrollmentRequest.getTitle());
		enrollmentDaoRequest.setFfnumber(emiratesServiceResponse.getFfNum());
		
		return enrollmentDaoRequest;
	}
}



