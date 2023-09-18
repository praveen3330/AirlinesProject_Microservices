package com.barclays.transfer.exception;

import lombok.Data;
import lombok.Getter;

/**
 * 
 * @author Praveen by 30-May-2023
 * Description :
 *
 */
@Getter
public class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6077376949573397847L;
	private final String errorCode;
	private final String errrorMsg;
	
	public SystemException(String errorCode, String errorMsg) {
		this.errorCode=errorCode;
		this.errrorMsg=errorMsg;
}
}
