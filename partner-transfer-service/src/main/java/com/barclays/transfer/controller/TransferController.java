
/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.transfer.dto.TransferRequest;
import com.barclays.transfer.dto.TransferResponse;
import com.barclays.transfer.service.ITransferService;
import com.barclays.transfer.validator.TransferValidator;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@RestController
@RequestMapping("/v1")
public class TransferController {
	
	@Autowired
	TransferValidator linkingValidator;
	
	@Autowired
	ITransferService linkingService;

	@PostMapping("/linking")
	public TransferResponse transfer(@RequestBody TransferRequest linkingRequest,
															@RequestHeader("client_id") String clientId, 
															@RequestHeader("channel_id") String channelId,
															@RequestHeader("message_ts") String messageTimeStamp,
															@RequestHeader("correlation_id") String requestId,
															@RequestHeader("access_token") String accessToken) {
	return null;
	}
	
}












