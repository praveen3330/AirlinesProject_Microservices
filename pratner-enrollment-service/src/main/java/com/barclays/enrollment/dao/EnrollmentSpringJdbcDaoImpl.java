/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.enrollment.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.barclays.enrollment.model.EnrollmentDaoRequest;
import com.barclays.enrollment.model.EnrollmentDaoResponse;
import com.barclays.enrollment.util.EnrollmentConstant;

/**
 * @author Praveen by 20-Aug-2023
 * Description :
 *
 */
@Component
public class EnrollmentSpringJdbcDaoImpl extends StoredProcedure implements IEnrollmentDao{

	@Autowired	
	public EnrollmentSpringJdbcDaoImpl(JdbcTemplate jdbcTemplate) {
		
		super(jdbcTemplate, "ENROLLMENT_SP001 ");
		registerStoredProcParams();
		
	}
	
	private void registerStoredProcParams() {
		
		//register input prams
		declareParameter(new SqlParameter("CLIENT_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("firstname", Types.VARCHAR));
		declareParameter(new SqlParameter("id", Types.VARCHAR));
		declareParameter(new SqlParameter("lastname", Types.VARCHAR));
		declareParameter(new SqlParameter("title", Types.VARCHAR));
		declareParameter(new SqlParameter("gender", Types.VARCHAR));
		declareParameter(new SqlParameter("mobnum", Types.VARCHAR));
		declareParameter(new SqlParameter("homeaddress", Types.VARCHAR));
		declareParameter(new SqlParameter("officeaddress", Types.VARCHAR));
		declareParameter(new SqlParameter("state", Types.VARCHAR));
		declareParameter(new SqlParameter("city", Types.VARCHAR));
		declareParameter(new SqlParameter("country", Types.VARCHAR));
		declareParameter(new SqlParameter("pincode", Types.VARCHAR));
		declareParameter(new SqlParameter("ffnumber", Types.VARCHAR));
		declareParameter(new SqlParameter("emailid", Types.VARCHAR));
		declareParameter(new SqlParameter("middlename", Types.VARCHAR));
		declareParameter(new SqlParameter("dateofbirth", Types.VARCHAR));
	
		//register out params
		declareParameter(new SqlOutParameter("RESPCODE_OUT", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESPMSG_OUT", Types.VARCHAR));
		
		compile();
		
	}

	@Override
	public EnrollmentDaoResponse enrollment(EnrollmentDaoRequest enrollmentDaoReq) {
		
		EnrollmentDaoResponse enrollmentDaoResponse = null;
	
	Map<String,	Object> inParams = new HashMap<String, Object>();
	
	
	inParams.put("CLIENT_ID_IN", "web");
	inParams.put("CHANNEL_ID_IN", "online");
	inParams.put("firstname", enrollmentDaoReq.getFirstname());
	inParams.put("id", enrollmentDaoReq.getCustid());
	inParams.put("lastname", enrollmentDaoReq.getLastName());
	inParams.put("title", enrollmentDaoReq.getTitle());
	inParams.put("gender", enrollmentDaoReq.getGender());
	inParams.put("mobnum", enrollmentDaoReq.getMobilenum());
	inParams.put("homeaddress", enrollmentDaoReq.getAddress().getHomeaddress());
	inParams.put("officeaddress", enrollmentDaoReq.getAddress().getResidencyaddress());
	inParams.put("state", enrollmentDaoReq.getState());
	inParams.put("city", enrollmentDaoReq.getCity());
	inParams.put("country", enrollmentDaoReq.getCountry());
	inParams.put("pincode", enrollmentDaoReq.getPincode());
	inParams.put("ffnumber", enrollmentDaoReq.getFfnumber());
	inParams.put("emailid", enrollmentDaoReq.getEmailid());
	inParams.put("middlename", enrollmentDaoReq.getMiddleName());
	inParams.put("dateofbirth", enrollmentDaoReq.getDob());
	
	
	Map<String, Object> outPrams = super.execute(inParams);
	
	String respCode = outPrams.get("RESPCODE_OUT").toString();
	String respMsg = outPrams.get("RESPMSG_OUT").toString();
	
	System.out.println("respcode :" + respCode+"RespMsg :"+respMsg);
	
	if( EnrollmentConstant.ZERO.equals(respCode)) {
		
		 enrollmentDaoResponse = new EnrollmentDaoResponse();
		
		enrollmentDaoResponse.setRespCode(respCode);
		enrollmentDaoResponse.setRespMsg(respMsg);
		enrollmentDaoResponse.setDesc("saved data successfully");
		}else {
			//todo : handle error scenarios
		}
		return enrollmentDaoResponse;
	}
}


