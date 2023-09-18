
/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.enrollment.exception.BusinessException;
import com.barclays.enrollment.exception.EnrollmentRequestInvalidException;
import com.barclays.enrollment.exception.SystemException;
import com.barclays.enrollment.model.EnrollmentRequest;
import com.barclays.enrollment.model.EnrollmentResponse;
import com.barclays.enrollment.service.IEnrollmentService;
import com.barclays.enrollment.validator.EnrollmentValidator;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@RestController
@RequestMapping("/v1")
public class EnrollmentController {

	@Autowired
	IEnrollmentService enrollmentService;
	
	@Autowired
	EnrollmentValidator enrollmentValidator;
	
	@PostMapping("/enrollment")
	@ResponseBody
	public ResponseEntity<EnrollmentResponse> enrollement(@RequestBody  EnrollmentRequest enrollmentRequest,   
			                                                                 @RequestHeader("client_id") String clientId, 
			                                                                 @RequestHeader("channel_id") String channelId,
			                                                                 @RequestHeader("message_ts") String messageTimeStamp,
			                                                                 @RequestHeader("correlation_id") String requestId,
			                                                                 @RequestHeader("access_token") String accessToken) throws EnrollmentRequestInvalidException, BusinessException, SystemException {
	
		//1. Get the request from client/consumer
		
		//2. Validate the request
		enrollmentValidator.validateRequest(enrollmentRequest);
		
		//3. Prepare the request for service
		
		//4. Call the service and get the response
		EnrollmentResponse enrollmentResponse = enrollmentService.enrollment(enrollmentRequest);
		
		return new ResponseEntity<EnrollmentResponse>(enrollmentResponse, HttpStatus.OK);
		
	}
}









