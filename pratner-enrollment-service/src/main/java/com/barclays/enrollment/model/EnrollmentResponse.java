/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@JsonInclude(value = Include.NON_NULL)
@Data
public class EnrollmentResponse {

	private String respCode;
	private String respMsg;
	private String desc;
	private String ffNumber;
	private String airlineName;
	
}
