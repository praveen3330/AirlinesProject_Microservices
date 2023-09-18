/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.emirates.enrollment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.enrollment.model.EnrollmentRequest;
import com.emirates.enrollment.model.EnrollmentResponse;

/**
 * @author Praveen by 12-Jun-2023
 * Description :
 *
 */

@RestController
@RequestMapping("/v1")
public class EnrollmentController {

	@PostMapping("/enrollment")
	@ResponseBody
	public  ResponseEntity<EnrollmentResponse> enroll(EnrollmentRequest enrollmentRequest,
			                                                        @RequestHeader("Client-id") String clientId,
			                                                        @RequestHeader("message-ts") String messageTs,
			                                                        @RequestHeader("request-id") String requestId,
			                                                        @RequestHeader("ipaddress") String ipadress) {
		
		System.out.println("Entered into Emirates Enrollment Service");
		
		EnrollmentResponse enrollmentResponse = new EnrollmentResponse();
		enrollmentResponse.setFfNum("FF345678");
		enrollmentResponse.setRespCode("0");
		enrollmentResponse.setRespMsg("success");
		enrollmentResponse.setDesc("enrollment done succesfully");
		
		return new ResponseEntity<EnrollmentResponse>(enrollmentResponse, HttpStatus.OK);
		
	}
}




















