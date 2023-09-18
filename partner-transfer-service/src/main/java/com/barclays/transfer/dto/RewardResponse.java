package com.barclays.transfer.dto;

import lombok.Data;

/**
 * 
 * @author Praveen by 24-Aug-2023
 * Description :
 *
 */
@Data
public class RewardResponse {

	private long availablePts;
	private long pendingPts;
	private long adjustPts;
	private long usedPts;
	
}
