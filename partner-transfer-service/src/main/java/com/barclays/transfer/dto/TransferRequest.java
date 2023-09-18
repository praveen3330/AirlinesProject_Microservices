package com.barclays.transfer.dto;

import lombok.Data;

/**
 * 
 * @author Praveen by 24-Aug-2023
 * Description :
 *
 */
@Data
public class TransferRequest {

	private String cardnum;
	private String custName;
	private long redeempoint;
	private float ratio;
	private String ffnum;
	private String airlineName;
	
}
