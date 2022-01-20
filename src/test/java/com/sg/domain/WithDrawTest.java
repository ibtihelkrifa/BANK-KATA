package com.sg.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sg.domain.Transaction.Type;

@RunWith(MockitoJUnitRunner.class)
public class WithDrawTest {

	
	@Mock
	private Statement statement;

	private Account account;
    
	@Before
	public void initialise() {
		account = new Account(statement);
	}
	
	@Test
	public void deposit_on_empty_account() {
		
		Statement statement = new Statement();
		statement.addStatementLine(new Transaction(Type.WITHDRAW, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		Account expectedAccount = new Account(statement);
		
		Account actualAccount = new Account(new Statement());
		actualAccount.deposit(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		assertThat(actualAccount).isEqualToComparingOnlyGivenFields(expectedAccount);
		
	}
	
	@Test
	public void deposit_on_non_empty_account() {
		
		Statement statement = new Statement();
		statement.addStatementLine(new Transaction(Type.WITHDRAW, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		statement.addStatementLine(new Transaction(Type.WITHDRAW, 2000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

		Account expectedAccount = new Account(statement);
		
		Account actualAccount = new Account(new Statement());
		actualAccount.deposit(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		actualAccount.deposit(2000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		assertThat(actualAccount).isEqualToComparingOnlyGivenFields(expectedAccount);
		
	}

	@Test
	public void withdraw_should_add_one_statement_line() {

		account.withdraw(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		Transaction transaction = new Transaction(Type.WITHDRAW, -1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		verify(statement).addStatementLine(transaction);
	}
}
