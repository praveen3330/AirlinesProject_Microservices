package com.barclays.linking.exception;

import lombok.Data;
import lombok.Getter;

/**
 * 
 * @author Praveen by 30-May-2023
 * Description :
 *
 */
@Getter
public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3173532731973521598L;
	private final String errorCode;
	private final String errrorMsg;
	
	public BusinessException(String errorCode, String errorMsg) {
		this.errorCode=errorCode;
		this.errrorMsg=errorMsg;
	}
}
