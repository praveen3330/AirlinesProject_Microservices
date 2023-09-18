package com.barclays.linking.dto;

import lombok.Data;
/**
 * 
 * @author Praveen by 23-Aug-2023
 * Description :
 *
 */
@Data
public class LinkingRequest {

	private String cardnum;
	private String emailId;
	private String  nameOntheCard;
	private String ffnumber;
	
}
