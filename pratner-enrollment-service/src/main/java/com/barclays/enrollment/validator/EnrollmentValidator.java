/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.validator;

import org.springframework.stereotype.Component;

import com.barclays.enrollment.exception.EnrollmentRequestInvalidException;
import com.barclays.enrollment.model.EnrollmentRequest;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Component
public class EnrollmentValidator {
	
	/**
	 * 
	 * Description 
	 * @param enrollmentRequest
	 * @throws EnrollmentRequestInvalidException 
	 */
	public void validateRequest(EnrollmentRequest enrollmentRequest) throws EnrollmentRequestInvalidException {
		
		// 1. request object is null or not
		if(enrollmentRequest == null) {
				
			throw new EnrollmentRequestInvalidException("ens001", "request object is invalid");
			
		}
		
		//2. first name validation
		if( enrollmentRequest.getFirstname() == null || " ".equals(enrollmentRequest.getFirstname())) {
			
			throw new EnrollmentRequestInvalidException("ens002", "firstname is invalid");
		}
		
		//3. email validations		
		if( enrollmentRequest.getEmailid() == null || " ".equals(enrollmentRequest.getEmailid())) {
			
			throw new EnrollmentRequestInvalidException("ens003", "email id is invalid");
		}
		
		//4. date of  birth validations
		
		//5. address validations
		
		//: 
		//:
		
		// check customer has already FFNumbet or not.
	}
}






