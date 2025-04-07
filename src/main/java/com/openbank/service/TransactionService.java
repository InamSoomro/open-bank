/**
 * 
 */
package com.openbank.service;

import java.util.List;


import com.openbank.model.Transaction;

/**
* 
* @author  inamsoomro
* @version 1.0
* @since   2019-05-25 
* 
*/
public interface TransactionService {
	
	
	public List<Transaction> getTransations();
	
	public List<Transaction> getTransationsByType(String type);

	public Double getTransationsTotalAmountByType(String type);

	

}
