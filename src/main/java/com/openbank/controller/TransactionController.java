/**
 * 
 */
package com.openbank.controller;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.openbank.model.Transaction;
import com.openbank.service.TransactionService; 

/**
* This rest endpoint controller class implements three 
* endpoints for open bank transactions 
* 
* @author  inamsoomro
* @version 1.0
* @since   2019-05-25 
* 
*/
@RestController
public class TransactionController {
	
	private final static Logger LOGGER = Logger.getLogger(TransactionController.class.getName());
	
	
	@Autowired
	TransactionService transactionService;

	
	/**
	 * This method implements the endpoint to list all open bank transactions
	 * @param None
	 * @return list of transactions
	 */
	@RequestMapping(value = "/transaction", produces = "application/json")
	public List<Transaction> getATransactions() {
		LOGGER.log(Level.INFO, "Getting Transaction List");
		return transactionService.getTransations();
	}
	
	
	/**
	 * This method implements the endpoint to filter list all open bank transactions
	 * @param filter type
	 * @return list of filtered transactions by type
	 */
	@RequestMapping(value = "/transaction/{type}",produces = "application/json")
	public List<Transaction> getTransactionsByType(@PathVariable("type") String type) {
		LOGGER.log(Level.INFO, "Getting Transactions by type");
		return transactionService.getTransationsByType(type);
	}
	
	/**
	 * This method implements the endpoint to  return total amount by transaction type
	 * @param filter type
	 * @return total amount transactions by type
	 */
	@RequestMapping(value = "/transaction/totalamount/{type}",produces = "application/json")
	public Double getTransactionsTotalAmountByType(@PathVariable("type") String type) {
		LOGGER.log(Level.INFO, "Getting Transactions total amount by type");
		return transactionService.getTransationsTotalAmountByType(type);
	}
	
		

}
