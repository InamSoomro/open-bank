/**
 * 
 */
package com.openbank.remoteservice;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openbank.controller.TransactionController;
import com.openbank.model.Transaction;

/**
 * This remote Service class implements the Rest client to communicate with
 * external endpoints.
 * 
 * @author inamsoomro
 * @version 1.0
 * @since 2019-05-25
 * 
 */
@Service
public class RemoteCallService {

	private final static Logger LOGGER = Logger.getLogger(TransactionController.class.getName());

	// TODO move this to properties file
	private final static String URI = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";

	/**
	 * This method implements the logic to create a rest endpoint and make calls to
	 * remote URI Parse the JSON to read the transactions
	 * 
	 * @param None
	 * @return transaction from the root node
	 */
	private JsonNode makeRemoteApiCall() {
		LOGGER.log(Level.INFO, "Calling the remote apisandbox API");

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(URI, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		try {
			root = mapper.readTree(response.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return root.get("transactions");

	}

	/**
	 * This method implements the logic to parse the json and map the transaction
	 * fields between back base and open bank
	 * 
	 * @param None
	 * @return list of transaction
	 */
	public List<Transaction> getTransactionList() {
		LOGGER.log(Level.INFO, "executing method transactionlist");

		JsonNode transactions = this.makeRemoteApiCall();

		if (transactions != null && transactions.isArray()) {
			LOGGER.log(Level.INFO, "parsing the transactions json");
			Transaction transaction = null;
			List<Transaction> transactionList = new ArrayList<Transaction>();

			for (JsonNode node : transactions) {

				transaction = new Transaction();
				transaction.setId(node.get("id").asLong());
				transaction.setAccountId(node.get("this_account").get("id").asText());
				transaction.setCounterpartyAccount(node.get("other_account").get("number").asText());
				transaction.setCounterpartyName(node.get("other_account").get("holder").get("name").asText());
				transaction.setCounterPartyLogoPath(node.get("other_account").get("metadata").get("image_URL").asText());
				transaction.setInstructedAmount(node.get("details").get("value").get("amount").asText());
				transaction.setInstructedCurrency(node.get("details").get("value").get("currency").asText());
				transaction.setTransactionType(node.get("details").get("type").asText());
				transaction.setDescription(node.get("details").get("description").asText());

				transactionList.add(transaction);
			} // end for loop
			LOGGER.log(Level.INFO, "return the list of transactions "+transactionList.size());
			return transactionList;
		} // end if
		return null;
	}

	/**
	 * This method implements the logic to parse the json and map the transaction by type
	 * fields between back base and open bank
	 * 
	 * @param type
	 * @return list of transaction by type
	 */
	public List<Transaction> getTransactionListByType(String type) {
		LOGGER.log(Level.INFO, "executing method transactionListByType by type "+type);

		JsonNode transactions = this.makeRemoteApiCall();

		if (transactions != null && transactions.isArray()) {
			LOGGER.log(Level.INFO, "parsing the transaction json");
			Transaction transaction = null;
			List<Transaction> transactionList = new ArrayList<Transaction>();
			for (JsonNode node : transactions) {

				transaction = new Transaction();
				if (type.equals(node.get("details").get("type").asText())) {
					transaction.setId(node.get("id").asLong());
					transaction.setAccountId(node.get("this_account").get("id").asText());
					transaction.setCounterpartyAccount(node.get("other_account").get("number").asText());
					transaction.setCounterpartyName(node.get("other_account").get("holder").get("name").asText());
					transaction.setCounterPartyLogoPath(
							node.get("other_account").get("metadata").get("image_URL").asText());
					transaction.setInstructedAmount(node.get("details").get("value").get("amount").asText());
					transaction.setInstructedCurrency(node.get("details").get("value").get("currency").asText());
					transaction.setTransactionType(node.get("details").get("type").asText());
					transaction.setDescription(node.get("details").get("description").asText());
					transactionList.add(transaction);
				}
			}//end for loop
			LOGGER.log(Level.INFO, "return the list of transactions by type "+transactionList.size());
			return transactionList;
		}// end if
		return null;
	}

	/**
	 * This method implements the logic to parse the json and map the transaction by type 
	 * and calculates the total amount by transactions
	 * 
	 * @param type
	 * @return total amount by transactions
	 */
	public Double getTransactionTotalAmountByType(String type) {
		LOGGER.log(Level.INFO, "executing method transactionTotalAmountByType by type "+type);

		JsonNode transactions = this.makeRemoteApiCall();
		if (transactions != null && transactions.isArray()) {
			LOGGER.log(Level.INFO, "parsing the transaction json");
			Double totalAmount = 0.0D;

			for (JsonNode node : transactions) {

				if (type.equals(node.get("details").get("type").asText())) {
					totalAmount += node.get("details").get("value").get("amount").asDouble();
				}
			}//end for loop
			LOGGER.log(Level.INFO, "return the total amount by transaction type" + totalAmount);
			return totalAmount;
		}// end if
		return null;
	}

}