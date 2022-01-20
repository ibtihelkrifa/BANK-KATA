package com.sg.domain;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.sg.domain.Transaction.Type;

public class TransactionTest {

	
	@Test
	public void equals_true_if_compare_the_same_transaction() {
		
		Transaction transaction1 = new Transaction(new Console(), Type.DEPOSIT, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		assertEquals(transaction1, transaction1);
	}
	
	@Test
	public void equals_false_if_compare_to_null() {
		
		Transaction transaction1 = new Transaction(new Console(), Type.DEPOSIT, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		assertNotEquals(transaction1, null);
	}
	
	@Test
	public void equals_false_if_compare_to_another_object() {
		
		Transaction transaction1 = new Transaction(new Console(), Type.DEPOSIT, 2000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		assertNotEquals(transaction1, "");
	}
	
	@Test
	public void equals_false_if_different_amounts() {
		
		Transaction transaction1 = new Transaction(new Console(), Type.DEPOSIT, 2000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		Transaction transaction2 = new Transaction(new Console(), Type.DEPOSIT, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		assertNotEquals(transaction1, transaction2);
	}
	
	@Test
	public void equals_false_if_different_date() {
		
		Transaction transaction1 = new Transaction(new Console(), Type.DEPOSIT, 2000, LocalDate.parse("20/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		Transaction transaction2 = new Transaction(new Console(), Type.DEPOSIT, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		assertNotEquals(transaction1, transaction2);
	}
	
	@Test
	public void equals_false_if_different_operations() {
		
		Transaction transaction1 = new Transaction(new Console(), Type.WITHDRAW, 2000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		Transaction transaction2 = new Transaction(new Console(), Type.DEPOSIT, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		assertNotEquals(transaction1, transaction2);
	}
	
}
