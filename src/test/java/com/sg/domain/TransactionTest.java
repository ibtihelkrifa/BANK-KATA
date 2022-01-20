package com.sg.domain;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.sg.domain.Transaction.Type;

public class TransactionTest {

	
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	@Test
	public void equals_true_if_compare_the_same_transaction() {
		
		Transaction transaction1 = new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));
		assertEquals(transaction1, transaction1);
	}
	
	@Test
	public void equals_false_if_compare_to_null() {
		
		Transaction transaction1 = new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));
		assertNotEquals(transaction1, null);
	}
	
	@Test
	public void equals_false_if_compare_to_another_object() {
		
		Transaction transaction1 = new Transaction(Type.DEPOSIT, 2000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));
		assertNotEquals(transaction1, "");
	}
	
	@Test
	public void equals_false_if_different_amounts() {
		
		Transaction transaction1 = new Transaction(Type.DEPOSIT, 2000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));
		Transaction transaction2 = new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));

		assertNotEquals(transaction1, transaction2);
	}
	
	@Test
	public void equals_false_if_different_date() {
		
		Transaction transaction1 = new Transaction(Type.DEPOSIT, 2000, LocalDateTime.parse("13-01-2019 17:09:42", DATE_TIME_FORMATTER));
		Transaction transaction2 = new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));

		assertNotEquals(transaction1, transaction2);
	}
	
	@Test
	public void equals_false_if_different_operations() {
		
		Transaction transaction1 = new Transaction(Type.WITHDRAW, 2000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));
		Transaction transaction2 = new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));

		assertNotEquals(transaction1, transaction2);
	}
	
}
