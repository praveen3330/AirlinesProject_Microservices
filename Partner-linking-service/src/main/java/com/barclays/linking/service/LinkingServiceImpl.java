/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.linking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.linking.dto.LinkingRequest;
import com.barclays.linking.dto.LinkingResponse;
import com.barclays.linking.dto.PartnerDetails;
import com.barclays.linking.entity.Linking;
import com.barclays.linking.repository.LinkingRepository;
import com.barclays.linking.serviceclient.ILinkingServiceClient;

/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Component
public class LinkingServiceImpl implements  ILinkingService{

	@Autowired
	ILinkingServiceClient linkingServiceClient;
	
	@Autowired
	LinkingRepository linkingRepository;
	
	@Override
	public LinkingResponse linking(LinkingRequest linkingRequest) {
		LinkingResponse linking = linkingServiceClient.linking(linkingRequest);
		
		//Once linking has been successful then stor the status with ffnumber,airlines
		//details in linking table
		
		return linking;
	}
    
	@Override
	public LinkingResponse getFFNumbers(String cardnumber) {
		
	List<Linking> linkingDaoResp = 	linkingRepository.findByCardnumber(cardnumber);
	
	System.out.println("linkingDaoResp is :" + linkingDaoResp);
	//convert backend response to Linking Response 
	
	LinkingResponse linkingResponse = new LinkingResponse();
	
	List<PartnerDetails> partnersList = new ArrayList<PartnerDetails>();
	
	for( Linking linking : linkingDaoResp ) {
		
		PartnerDetails partnerDetails = new PartnerDetails();
		partnerDetails.setAirlineName(linking.getAirlinename());
		partnerDetails.setFfnumber(linking.getFfnumber());
		
		partnersList.add(partnerDetails);
	
	}
	linkingResponse.setPartnerList(partnersList);
	
	return linkingResponse;
	}
}









