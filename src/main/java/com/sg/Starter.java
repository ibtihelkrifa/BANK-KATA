package com.sg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.sg.domain.Account;
import com.sg.domain.Console;
import com.sg.domain.Statement;

public class Starter {

	public static void main (String args[]) {
		
		Account account = new Account(new Statement());
		
		account.deposit(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		account.deposit(2000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		account.withdraw(1000, LocalDate.parse("19/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		account.printStatement(System.out, new Console());
		
		}
}
