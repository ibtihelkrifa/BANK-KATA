package com.sg.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sg.domain.Transaction.Type;

@RunWith(MockitoJUnitRunner.class)
public class DepositTest {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

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
		statement.addStatementLine(new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER)));
		Account expectedAccount = new Account(statement);
		
		Account actualAccount = new Account(new Statement());
		actualAccount.deposit(1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));
		
		assertThat(actualAccount).isEqualToComparingOnlyGivenFields(expectedAccount);
		
	}
	
	@Test
	public void deposit_on_non_empty_account() {
		
		Statement statement = new Statement();
		statement.addStatementLine(new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER)));
		statement.addStatementLine(new Transaction(Type.DEPOSIT, 2000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER)));

		Account expectedAccount = new Account(statement);
		
		Account actualAccount = new Account(new Statement());
		actualAccount.deposit(1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));
		actualAccount.deposit(2000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));

		assertThat(actualAccount).isEqualToComparingOnlyGivenFields(expectedAccount);
		
	}
	
	@Test
	public void deposit_should_add_one_statement_line() {

		account.deposit(1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));

		Transaction transaction = new Transaction(Type.DEPOSIT, 1000, LocalDateTime.parse("13-01-2017 17:09:42", DATE_TIME_FORMATTER));

		verify(statement).addStatementLine(transaction);
	}

	
}
