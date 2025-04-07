/**
 * 
 */
package com.openbank.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.openbank.model.Transaction;
import com.openbank.remoteservice.RemoteCallService;
import com.openbank.service.TransactionService;
import com.openbank.service.TransactionServiceImp;

/**
* Unit test cases for transaction services
* 
* @author  inamsoomro
* @version 1.0
* @since   2019-05-25 
* 
*/
@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {
	
	@Mock
    private RestTemplate restTemplate;
	
	@InjectMocks
    private TransactionService transactionService = new TransactionServiceImp();
 
	@InjectMocks
	RemoteCallService remoteCallService = new RemoteCallService();
	
	@Test
    public void get_transaction_list_Test() {
        List<Transaction> transactions= remoteCallService.getTransactionList();
        Assert.assertNotNull(transactions);
    }
	
	@Test
	public void get_transaction_list_by_type_Test() {
        Transaction transaction = new Transaction();
        transaction.setTransactionType("sandbox-payment");
        List<Transaction> transactions= remoteCallService.getTransactionListByType("sandbox-payment");
        Assert.assertNotNull(transactions);
        Assert.assertEquals("Equality Check", transaction.getTransactionType(), transactions.get(0).getTransactionType());
    }
	
	@Test
	public void get_transaction_total_amount_by_type_Test() {
       
		double expected_total_amount = 73.75999999999999;
        double actual_total_amount= remoteCallService.getTransactionTotalAmountByType("sandbox-payment");
        Assert.assertEquals(expected_total_amount,actual_total_amount,actual_total_amount);
    
    }
	
}
