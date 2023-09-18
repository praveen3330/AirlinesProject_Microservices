package com.barclays.transfer.dao;

import com.barclays.transfer.dto.TransferDaoRequest;
import com.barclays.transfer.dto.TransferDaoResponse;

/**
 * 
 * @author Praveen by 24-Aug-2023
 * Description :
 *
 */
public interface ITransferDao {

	TransferDaoResponse tranfer(TransferDaoRequest daoRequest);
	
	
}
