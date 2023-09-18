/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.transfer.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.barclays.transfer.dto.TransferRequest;
import com.barclays.transfer.dto.TransferResponse;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
public interface ITransferService {

	public TransferResponse transfer(@RequestBody TransferRequest linkingRequest) {
		
	}

}
