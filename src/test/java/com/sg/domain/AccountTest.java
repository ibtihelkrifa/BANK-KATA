package com.sg.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sg.domain.Transaction.Type;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	@Mock
	private Statement statement;
	@Mock 
	private Console console;
	private Account account;
    
	@Before
	public void initialise() {
		account = new Account(statement, console);
	}

	

	@Test
	public void deposit_should_add_one_statement_line() {

		account.deposit(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		Transaction transaction = new Transaction(console, Type.DEPOSIT, 1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		verify(statement).addStatementLine(transaction, 1000);
	}

	@Test
	public void withdraw_should_add_one_statement_line() {

		account.withdraw(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		Transaction transaction = new Transaction(console, Type.WITHDRAW, -1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		verify(statement).addStatementLine(transaction, -1000);
	}

	@Test
	public void should_print_statement() {

		PrintStream printer = System.out;

		account.printStatement(printer);

		verify(statement).printTo(printer, console);
	}
	
	@Test
	public void should_have_the_correct_format() {
		
		Console mockedConsole = mock(Console.class) ;
		
		Account account = new Account(new Statement(), mockedConsole);

		    PrintStream printer = System.out;
		  
			account.withdraw(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			account.deposit(2000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		    account.printStatement(printer);

		    verify(mockedConsole, times(1)).printLine("OPERATION | DATE | AMOUNT | BALANCE");
		    verify(mockedConsole, times(1)).printLine("WITHDRAW | 2022-01-19 | -1000.0 | -1000.0");
		    verify(mockedConsole, times(1)).printLine("DEPOSIT | 2022-01-19 | 2000.0 | 1000.0");

	}
	

}
