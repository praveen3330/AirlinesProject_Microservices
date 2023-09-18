/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.linking.service;

import com.barclays.linking.dto.LinkingRequest;
import com.barclays.linking.dto.LinkingResponse;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
public interface ILinkingService {

	
	public LinkingResponse linking(LinkingRequest linkingRequest);
	public LinkingResponse getFFNumbers(String cardnumber);


}
