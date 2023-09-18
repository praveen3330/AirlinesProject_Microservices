/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Component;

import com.barclays.enrollment.model.EnrollmentDaoRequest;
import com.barclays.enrollment.model.EnrollmentDaoResponse;
import com.barclays.enrollment.util.EnrollmentConstant;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Component
public class EnrollmentDaoImpl  /* implements  IEnrollmentDao */ {

	//@Override
	public EnrollmentDaoResponse enrollment(EnrollmentDaoRequest enrollmentDaoRequest)  {
		
		EnrollmentDaoResponse enrollmentDaoResponse = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/elps", "root", "1234");

			String storeproc = "CALL elps.ENROLLMENT_SP001 (?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			
			CallableStatement csmt = connection.prepareCall(storeproc);

			csmt.setString(1, "web***");
			csmt.setString(2, "online***");
			csmt.setString(3, enrollmentDaoRequest.getFirstname());
			csmt.setInt(4, enrollmentDaoRequest.getCustid());
			csmt.setString(5, enrollmentDaoRequest.getLastName());
			csmt.setString(6, enrollmentDaoRequest.getTitle());
			csmt.setString(7, enrollmentDaoRequest.getGender());
			csmt.setLong(8, enrollmentDaoRequest.getMobilenum());
			csmt.setString(9, enrollmentDaoRequest.getCity());
			csmt.setString(10, enrollmentDaoRequest.getAddress().getResidencyaddress());
			csmt.setString(11, enrollmentDaoRequest.getState());
			csmt.setString(12,enrollmentDaoRequest.getCity());
			csmt.setString(13, enrollmentDaoRequest.getCountry());
			csmt.setString(14, enrollmentDaoRequest.getPincode());
			csmt.setString(15, enrollmentDaoRequest.getFfnumber());
			csmt.setString(16, enrollmentDaoRequest.getEmailid());
			csmt.setString(17, enrollmentDaoRequest.getMiddleName());
			csmt.setString(18,enrollmentDaoRequest.getDob());
			
			csmt.registerOutParameter(19, Types.VARCHAR);
			csmt.registerOutParameter(29, Types.VARCHAR);
			
			csmt.execute();
			
			String respCode = csmt.getString(19);
			String respMsg = csmt.getString(20);
			
			if( EnrollmentConstant.ZERO.equals(respCode)) {
			
			enrollmentDaoResponse = new EnrollmentDaoResponse();
			
			enrollmentDaoResponse.setRespCode(respCode);
			enrollmentDaoResponse.setRespMsg(respMsg);
			enrollmentDaoResponse.setDesc("saved data successfully");
			}else {
				//todo : handle error scenarios
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {

		}
		return enrollmentDaoResponse;
	}

}
