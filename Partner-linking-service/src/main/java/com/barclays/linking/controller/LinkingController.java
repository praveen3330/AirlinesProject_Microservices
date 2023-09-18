
/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.linking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.linking.dto.LinkingRequest;
import com.barclays.linking.dto.LinkingResponse;
import com.barclays.linking.service.ILinkingService;
import com.barclays.linking.validator.LinkingValidator;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@RestController
@RequestMapping("/v1")
public class LinkingController {
	
	@Autowired
	LinkingValidator linkingValidator;
	
	@Autowired
	ILinkingService linkingService;

	@PostMapping("/linking")
	public LinkingResponse linking(@RequestBody LinkingRequest linkingRequest,
															@RequestHeader("client_id") String clientId, 
															@RequestHeader("channel_id") String channelId,
															@RequestHeader("message_ts") String messageTimeStamp,
															@RequestHeader("correlation_id") String requestId,
															@RequestHeader("access_token") String accessToken) {
	return null;
	}
		@GetMapping("/ffnumbers/{cardnumber}")
		public LinkingResponse getFFNumbers(@PathVariable("cardnumber") String cardnumber,
																				@RequestHeader("client_id") String clientId, 
																				@RequestHeader("channel_id") String channelId,
																				@RequestHeader("message_ts") String messageTimeStamp,
																				@RequestHeader("correlation_id") String requestId,
																				@RequestHeader("access_token") String accessToken) {
		
			//1. Get the request from consumer
			//2. validate the request
			//3. prepare the request for service
			//4.call the service and get the  service response
			
		LinkingResponse  linkingResponse = linkingService.getFFNumbers(cardnumber);
		linkingResponse.setRespCode("0");
		linkingResponse.setRespMsg("success");
			
			return linkingResponse;	
		}
}

