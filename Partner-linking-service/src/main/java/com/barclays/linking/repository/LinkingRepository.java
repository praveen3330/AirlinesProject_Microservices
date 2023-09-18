package com.barclays.linking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.barclays.linking.entity.Linking;

/**
 * 
 * @author Praveen by 22-Aug-2023
 * Description :
 *
 */
@Component
public interface LinkingRepository extends JpaRepository<Linking, Long> {

	List<Linking> findByCardnumber(String cardnumber);
	
}
