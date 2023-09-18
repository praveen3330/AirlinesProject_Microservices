/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.linking.exception;

import lombok.Data;
import lombok.Getter;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Getter
public class EnrollmentRequestInvalidException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6793573032786117718L;
	private String errorCode;
	private String errrorMsg;

	public EnrollmentRequestInvalidException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errrorMsg=errorMsg;
	}
	
}