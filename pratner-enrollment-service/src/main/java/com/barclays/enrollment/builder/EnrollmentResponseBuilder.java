/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.builder;

import org.springframework.stereotype.Component;

import com.barclays.enrollment.model.EmiratesServiceResponse;
import com.barclays.enrollment.model.EnrollmentDaoResponse;
import com.barclays.enrollment.model.EnrollmentResponse;

/**
 * 
 * @author Praveen by 01-Jun-2023
 * Description : This method is used to prepare enrollment response with the help of emirates response and dao response
 *
 */
@Component
public class EnrollmentResponseBuilder {

	public EnrollmentResponse buildEnrollmentResponse(EmiratesServiceResponse emiratesServiceResponse,
			EnrollmentDaoResponse daoResponse) {
	
		EnrollmentResponse enoEnrollmentResponse = new EnrollmentResponse();
		
		enoEnrollmentResponse.setAirlineName("emirates");
		enoEnrollmentResponse.setFfNumber(emiratesServiceResponse.getFfNum());
		enoEnrollmentResponse.setRespCode(daoResponse.getRespCode());
		enoEnrollmentResponse.setRespMsg(daoResponse.getRespMsg());
		enoEnrollmentResponse.setDesc(emiratesServiceResponse.getDesc());
		
		return enoEnrollmentResponse;
	}

}
