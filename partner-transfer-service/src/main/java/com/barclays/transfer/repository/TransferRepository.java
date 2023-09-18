package com.barclays.transfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Praveen by 22-Aug-2023
 * Description :
 *
 */
@Component
public interface TransferRepository extends JpaRepository<String, String> {

	
}
