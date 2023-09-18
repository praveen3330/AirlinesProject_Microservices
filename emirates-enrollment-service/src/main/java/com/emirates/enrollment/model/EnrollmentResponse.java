/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.emirates.enrollment.model;

import lombok.Data;

/**
 * @author Praveen by 12-Jun-2023
 * Description :
 *
 */
@Data
public class EnrollmentResponse {

	private String respCode;
	private String respMsg;
	private String ffNum;
	private String desc;
}
