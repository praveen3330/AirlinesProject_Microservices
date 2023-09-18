/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barclays.enrollment.model.EnrollmentResponse;
import com.barclays.enrollment.exception.EnrollmentRequestInvalidException;
import com.barclays.enrollment.exception.BusinessException;
import com.barclays.enrollment.exception.SystemException;
/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@ControllerAdvice
public class EnrollmentControllerAdvice {

	@ExceptionHandler(value = EnrollmentRequestInvalidException.class)
	@ResponseBody
	public ResponseEntity<EnrollmentResponse> handleRequestInvalidException(EnrollmentRequestInvalidException exception) {
		
		EnrollmentResponse enrollmentResponse = buildEnrollmentResponse(exception.getErrorCode(), exception.getErrrorMsg());
		
		return new ResponseEntity<EnrollmentResponse>(enrollmentResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public ResponseEntity<EnrollmentResponse> handleBusinessException(BusinessException exception) {
		
		EnrollmentResponse enrollmentResponse = buildEnrollmentResponse(exception.getErrorCode(), exception.getErrrorMsg());
		
		return new ResponseEntity<EnrollmentResponse>(enrollmentResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = SystemException.class)
	@ResponseBody
	public ResponseEntity<EnrollmentResponse> handleSystemException(SystemException exception) {
		
		EnrollmentResponse enrollmentResponse = buildEnrollmentResponse(exception.getErrorCode(), exception.getErrrorMsg());
		
		return new ResponseEntity<EnrollmentResponse>(enrollmentResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<EnrollmentResponse> handleGenericException(Exception exception) {
		
		EnrollmentResponse enrollmentResponse = buildEnrollmentResponse("ENR999",  "UNKNOWN ERROR FROM SERVICE");
		
		return new ResponseEntity<EnrollmentResponse>(enrollmentResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private EnrollmentResponse buildEnrollmentResponse(String errorCode, String errorMsg) {
		EnrollmentResponse enrollmentResponse = new EnrollmentResponse();
		enrollmentResponse.setRespCode(errorCode);
		enrollmentResponse.setRespMsg(errorMsg);
		return enrollmentResponse;
	}	
}






