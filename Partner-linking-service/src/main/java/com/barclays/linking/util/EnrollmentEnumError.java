/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.linking.util;

import lombok.Getter;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Getter
public enum EnrollmentEnumError {

	firstname_emr001("emr001", "****firstname invalid as per emirates standards*****", "data error"),
	firstname_emr002("emr002", "firstname invalid as per emirates standards", "data error"),
	firstname_emr003("emr003", "firstname invalid as per emirates standards", "data error"),
	firstname_emr004("emr004", "firstname invalid as per emirates standards", "data error"),
	firstname_emr005("emr005", "firstname invalid as per emirates standards", "data error"),
	firstname_emr006("emr006", "firstname invalid as per emirates standards", "data error"),
	firstname_emr007("emr007", "firstname invalid as per emirates standards", "data error"),
	firstname_emr008("emr008", "firstname invalid as per emirates standards", "data error"),
	firstname_emr009("emr009", "firstname invalid as per emirates standards", "data error");

	private String errorCode;
	private String errorMsg;
	private String typeOfError;
	
	 EnrollmentEnumError(String errorCode, String errorMsg, String typeOfError) {
		
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.typeOfError = typeOfError;
	}	
	 
	 public static boolean checkErrorCodes(String errorCodes, String typeOfError) {
		 
		 boolean flag = true;
		 
		 for(EnrollmentEnumError enumObj : EnrollmentEnumError.values()) {
			 
			 if(errorCodes.equals(enumObj.getErrorCode()) && typeOfError.equals(enumObj.getTypeOfError())) {
				 
				 return flag;
			 }
		 } 
		 return false;
	 }
}
