package com.barclays.enrollment.serviceclient;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.barclays.enrollment.util.EnrollmentConstant;
import com.barclays.enrollment.util.EnrollmentEnumError;
import com.barclays.enrollment.exception.BusinessException;
import com.barclays.enrollment.exception.SystemException;
import com.barclays.enrollment.model.EmiratesServiceRequest;
import com.barclays.enrollment.model.EmiratesServiceResponse;
import com.barclays.enrollment.util.EnrollmentEnumError;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;

@Component
public class EmiratesServiceClientImpl implements IEmiratesServiceClient{

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${emirates_enrollment_service_url}")
	private String emiratesServiceUrl;
	
	@Override
	public EmiratesServiceResponse enrollment(EmiratesServiceRequest enrollmentsServiceRequest) throws BusinessException, SystemException {
		
		// TODO: Write the client code to call the emirates service and get the response
		EmiratesServiceResponse enEmiratesSvcResponse = new EmiratesServiceResponse();
		
		String partnerRespCode = null;
		String partnerRespMsg = null;
		
		
		MultiValueMap<String, Object> headers = new LinkedMultiValueMap <String, Object>();
	
		headers.add("Client-id", "web");
		headers.add("message-ts","10.0.0.150");
		headers.add("request-id", new Date().toString());
		headers.add("ipaddress", UUID.randomUUID().toString().subSequence(0, 10));
		
		HttpEntity requestEntity = new HttpEntity(enrollmentsServiceRequest,headers);
	
		try {
			
			ResponseEntity<EmiratesServiceResponse>responseEntity = restTemplate.exchange(emiratesServiceUrl, HttpMethod.POST, requestEntity, EmiratesServiceResponse.class);
			
			System.out.println("responseEntity is ::" + responseEntity);
			
			if( 200 == responseEntity.getStatusCode().OK.value()) {
				
				enEmiratesSvcResponse = responseEntity.getBody();
				
				partnerRespCode = enEmiratesSvcResponse.getRespCode();
				partnerRespMsg = enEmiratesSvcResponse.getRespMsg();
				
			}else if(EnrollmentEnumError.checkErrorCodes(partnerRespCode, EnrollmentConstant.DATA_ERROR)) {
				
				throw new BusinessException(partnerRespCode, partnerRespMsg);
			}
			else if(EnrollmentEnumError.checkErrorCodes(partnerRespCode, EnrollmentConstant.SYSTEM_ERROR) ) {
				
				throw new SystemException(partnerRespCode, partnerRespMsg);
			} else {
				throw new SystemException(EnrollmentConstant.UNKNOWN_ERROR_CODE, EnrollmentConstant.UNKNOWN_ERROR_MSG);
			}
		}	catch (BusinessException be) {
			//Todo : error logging 
				throw be;
		} catch (SystemException se) {
			// TODO Auto-generated catch block
	            throw se;
		}
		return enEmiratesSvcResponse;
	}
}

