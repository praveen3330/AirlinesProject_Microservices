/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.barclays.enrollment.builder.EnrollmentRequestBuilder;
import com.barclays.enrollment.builder.EnrollmentResponseBuilder;
import com.barclays.enrollment.dao.IEnrollmentDao;
import com.barclays.enrollment.exception.BusinessException;
import com.barclays.enrollment.exception.SystemException;
import com.barclays.enrollment.model.Address;
import com.barclays.enrollment.model.EmiratesServiceRequest;
import com.barclays.enrollment.model.EmiratesServiceResponse;
import com.barclays.enrollment.model.EnrollmentDaoRequest;
import com.barclays.enrollment.model.EnrollmentDaoResponse;
import com.barclays.enrollment.model.EnrollmentRequest;
import com.barclays.enrollment.model.EnrollmentResponse;
import com.barclays.enrollment.serviceclient.IEmiratesServiceClient;
import com.barclays.enrollment.util.EnrollmentConstant;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Component
public class EnrollmentServiceImpl implements  IEnrollmentService{

	@Autowired
	IEmiratesServiceClient emiratesServiceClient;
	
	@Autowired
	IEnrollmentDao enrollmentDao;
	
	@Autowired
	EnrollmentRequestBuilder enrollmentRequestBuilder;
	
	@Autowired
	EnrollmentResponseBuilder enrollmentResponseBuilder;
	
	@Override
	public EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest) throws BusinessException, SystemException {

		EnrollmentDaoResponse daoResponse = null;
		
		//1. Get the request from controller
		
		//2. Call enrollmentRequestBuilder for EmiratesServiceRequest object
		 EmiratesServiceRequest emiratesServiceRequest = enrollmentRequestBuilder.buildEmiratesRequest(enrollmentRequest);
		
		//3. Call service client and get the response
		EmiratesServiceResponse emiratesServiceResponse = emiratesServiceClient.enrollment(emiratesServiceRequest);
		
		//4. If the service client will success response then proceed further
		if(emiratesServiceResponse != null &&  EnrollmentConstant.ZERO.equals(emiratesServiceResponse.getRespCode() ) ){
			
		//5. Prepare the request for dao
		EnrollmentDaoRequest enrollmentDaoRequest =	enrollmentRequestBuilder.buildDaoRequest(enrollmentRequest, emiratesServiceResponse);
			
		//6. Call dao and get the response
		 daoResponse = enrollmentDao.enrollment(enrollmentDaoRequest);
		
		}
		//7.  Call enrollmentResponseBuilder
	
		EnrollmentResponse enoEnrollmentResponse = enrollmentResponseBuilder.buildEnrollmentResponse(emiratesServiceResponse, daoResponse);
		
		return enoEnrollmentResponse;	
	}

}

