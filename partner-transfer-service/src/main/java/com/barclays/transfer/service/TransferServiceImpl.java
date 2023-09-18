/*@CopyRight 2023 Citibank pvt ltd. All Rights are reserved. You shouldn't disclose
* the information outside, otherwise terms and conditions will apply.
*
*/
package com.barclays.transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.transfer.util.TransferUitil;
import com.barclays.transfer.dao.ITransferDao;
import com.barclays.transfer.dto.RewardResponse;
import com.barclays.transfer.dto.TransferDaoRequest;
import com.barclays.transfer.dto.TransferDaoResponse;
import com.barclays.transfer.dto.TransferRequest;
import com.barclays.transfer.dto.TransferResponse;
import com.barclays.transfer.intg.serviceclient.IBritishAirlineServiceClient;
import com.barclays.transfer.intg.serviceclient.IRewardService;
/**
 * @author Praveen by 19-May-2023
 * Description :
 *
 */
@Component
public class TransferServiceImpl implements  ITransferService{

	@Autowired
	ITransferDao iTransferDao;
	
	@Autowired
	IRewardService rewardService;
	
	@Autowired
	IBritishAirlineServiceClient iBritishAirlineServiceClient;
	
	@Autowired
	
	
	@Override
	public TransferResponse transfer(TransferRequest transferRequest) {
	
		TransferResponse transferResponse = new TransferResponse();
		
		//1. we need make reward-service call
		
		long availablePts = 100000;
		
		RewardResponse rewardResp = rewardService.getRewardsInfo(transferRequest.getCardnum());
		
		
		if ( transferRequest.getRedeempoint() < rewardResp.getAvailablePts()) {
			
			//Make database call to hold these points 
			//i.e. move from available to  pending points , pending points = 1000
			//avaialvale points = 9000
			
			TransferDaoRequest daoRequest = new TransferDaoRequest();
			
			TransferDaoResponse	daoResponse = iTransferDao.tranfer(daoRequest);
			
			String airlineType = TransferUitil.checkAirlineType(transferRequest.getAirlineName());
			
			if(  "realtime".equals(airlineType) ) {
				
				//call airline integration layer
			}else {
				//call airlines message publisher
			}
			
			//based on airlines response make database calls to update the reward points
			
		}else {
			// send error : insuffient reward points, please try again after sometime
			
		}
		
		
		return transferResponse;
	}

}

