/**
 * 
 */
package com.openbank.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.openbank.model.Transaction;
import com.openbank.remoteservice.RemoteCallService;

/**
* This Service class acts as a bridge between controller the remote service calls
* 
* @author  inamsoomro
* @version 1.0
* @since   2019-05-25 
* 
*/
@Service
public class TransactionServiceImp implements TransactionService {

	@Autowired
	RemoteCallService remoteCallService;
	
	/**
	 * This method implements the logic to call remote service for transaction list
	 * @param None
	 * @return list of transactions
	 */
	public List<Transaction> getTransations() {
		
		List<Transaction> transactionList = remoteCallService.getTransactionList();
		return transactionList;
	}

	/**
	 * This method implements the logic to call remote service for transaction list by time
	 * @param type
	 * @return list of transactions by time
	 */
	public List<Transaction> getTransationsByType(String type) {
		List<Transaction> transactionList = remoteCallService.getTransactionListByType(type);
		return transactionList;
	}

	/**
	 * This method implements the logic to call remote service to get total amount by transaction type
	 * @param type
	 * @return total amount by transaction type
	 */
	public Double getTransationsTotalAmountByType(String type) {
		
		return remoteCallService.getTransactionTotalAmountByType(type);
	}

}
