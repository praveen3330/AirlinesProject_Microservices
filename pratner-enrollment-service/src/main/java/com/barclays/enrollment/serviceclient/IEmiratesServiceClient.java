/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.serviceclient;

import com.barclays.enrollment.exception.BusinessException;
import com.barclays.enrollment.exception.SystemException;
import com.barclays.enrollment.model.EmiratesServiceRequest;
import com.barclays.enrollment.model.EmiratesServiceResponse;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
public interface IEmiratesServiceClient {

	EmiratesServiceResponse enrollment(EmiratesServiceRequest enrollmentsServiceRequest) throws BusinessException, SystemException;
	
}
