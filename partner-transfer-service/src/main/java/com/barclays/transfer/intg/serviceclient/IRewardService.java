package com.barclays.transfer.intg.serviceclient;

import com.barclays.transfer.dto.RewardResponse;

/**
 * 
 * @author Praveen by 24-Aug-2023
 * Description :
 *
 */
public interface IRewardService {

	RewardResponse getRewardsInfo(String cardnum);
	
	
}
