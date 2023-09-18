/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.dao;

import com.barclays.enrollment.model.EnrollmentDaoRequest;
import com.barclays.enrollment.model.EnrollmentDaoResponse;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
public interface IEnrollmentDao {

	EnrollmentDaoResponse enrollment(EnrollmentDaoRequest enrollmentDaoReq);
}
