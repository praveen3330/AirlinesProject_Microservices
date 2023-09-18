package com.barclays.linking.dto;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author Praveen by 23-Aug-2023
 * Description :
 *
 */
@Data
public class LinkingResponse {

	private String respCode;
	private String respMsg;
	private String status;
	private List<PartnerDetails> partnerList;
	
}
