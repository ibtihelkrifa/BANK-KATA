package com.sg.domain;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountPrinterTest {
	
	@Test
	public void should_print_header_and_balance_when_no_operation() {
		
		Console mockedConsole = mock(Console.class) ;
		
		Account account = new Account(new Statement());

		    PrintStream printer = System.out;
		  
		    account.printStatement(printer, mockedConsole);

		    verify(mockedConsole).printLine("OPERATION | DATE | AMOUNT");
		    verify(mockedConsole).printLine("BALANCE : 0.0");

	}
	
	@Test
	public void should_print_one_line_afer_one_deposit_operation() {
		
		Console mockedConsole = mock(Console.class) ;
		
		Account account = new Account(new Statement());

		    PrintStream printer = System.out;
		  
			account.deposit(2000, LocalDateTime.parse("2017-01-13T09:32:50.303"));

		    account.printStatement(printer, mockedConsole);

		    verify(mockedConsole).printLine("OPERATION | DATE | AMOUNT");
		    verify(mockedConsole).printLine("DEPOSIT | 2017-01-13T09:32:50.303 | 2000.0");
		    verify(mockedConsole).printLine("BALANCE : 2000.0");

	}

	@Test
	public void should_print_one_line_afer_one_withdraw_operation() {
		
		Console mockedConsole = mock(Console.class) ;
		
		Account account = new Account(new Statement());

		    PrintStream printer = System.out;
		  
			account.withdraw(2000, LocalDateTime.parse("2017-01-13T09:32:50.303"));

		    account.printStatement(printer, mockedConsole);

		    verify(mockedConsole).printLine("OPERATION | DATE | AMOUNT");
		    verify(mockedConsole).printLine("WITHDRAW | 2017-01-13T09:32:50.303 | -2000.0");
		    verify(mockedConsole).printLine("BALANCE : -2000.0");

	}
	
	@Test
	public void should_print_multiple_line_when_multiple_operations() {
		
		Console mockedConsole = mock(Console.class) ;
		
		Account account = new Account(new Statement());

		    PrintStream printer = System.out;
		  
			account.deposit(2000, LocalDateTime.parse("2017-01-13T09:32:50.303"));
			account.withdraw(1000, LocalDateTime.parse("2017-01-14T09:32:50.303"));

		    account.printStatement(printer, mockedConsole);

		    verify(mockedConsole, times(1)).printLine("OPERATION | DATE | AMOUNT");
		    verify(mockedConsole).printLine("DEPOSIT | 2017-01-13T09:32:50.303 | 2000.0");
		    verify(mockedConsole).printLine("WITHDRAW | 2017-01-14T09:32:50.303 | -1000.0");
		    verify(mockedConsole).printLine("BALANCE : 1000.0");


	}
}
