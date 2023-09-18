/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.service;

import com.barclays.enrollment.exception.BusinessException;
import com.barclays.enrollment.exception.SystemException;
import com.barclays.enrollment.model.EmiratesServiceRequest;


import com.barclays.enrollment.model.EmiratesServiceResponse;
import com.barclays.enrollment.model.EnrollmentRequest;
import com.barclays.enrollment.model.EnrollmentResponse;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
public interface IEnrollmentService {

//	EmiratesServiceResponse enrollment(EmiratesServiceRequest enrollmentServiceReq);

	EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest) throws BusinessException, SystemException;


}
