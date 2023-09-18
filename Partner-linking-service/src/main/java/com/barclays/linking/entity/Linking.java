package com.barclays.linking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Praveen by 23-Aug-2023
 * Description :
 *
 */
@Table(name = "Linking")
@Entity
@Data
public class Linking {

	@Id
	private int id;
	private String cardnumber;
	private String ffnumber;
	private String airlinename;
	private String status;
	
}
