/**
 * 
 */
package com.openbank.model;

/**
* Java bean object for transaction 
* mapping between Back Base and open Bank
* 
* @author  inamsoomro
* @version 1.0
* @since   2019-05-25 
* 
*/
public class Transaction { 
	
	
	private long id;
	private String accountId;
	
	private String counterpartyAccount;
	private String counterpartyName;
	private String counterPartyLogoPath;
	private String instructedAmount;
	private String instructedCurrency;
	private long transactionAmount; //convert it to Big Decimal for precisions
	private String transactionCurrency;
	private String transactionType;
	private String description;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCounterpartyAccount() {
		return counterpartyAccount;
	}
	public void setCounterpartyAccount(String counterpartyAccount) {
		this.counterpartyAccount = counterpartyAccount;
	}
	public String getCounterpartyName() {
		return counterpartyName;
	}
	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}
	public String getCounterPartyLogoPath() {
		return counterPartyLogoPath;
	}
	public void setCounterPartyLogoPath(String counterPartyLogoPath) {
		this.counterPartyLogoPath = counterPartyLogoPath;
	}
	public String getInstructedAmount() {
		return instructedAmount;
	}
	public void setInstructedAmount(String instructedAmount) {
		this.instructedAmount = instructedAmount;
	}
	public String getInstructedCurrency() {
		return instructedCurrency;
	}
	public void setInstructedCurrency(String instructedCurrency) {
		this.instructedCurrency = instructedCurrency;
	}
	public long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionCurrency() {
		return transactionCurrency;
	}
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
