package com.sg;

import java.time.LocalDateTime;

import com.sg.domain.Account;
import com.sg.domain.Console;
import com.sg.domain.Statement;

public class Starter {

	public static void main (String args[]) {
		
		Account account = new Account(new Statement());
		
		account.deposit(1000,  LocalDateTime.parse("2017-01-13T09:32:50.303"));
		account.deposit(2000,  LocalDateTime.parse("2017-01-14T09:32:50.303"));
		account.withdraw(1000,  LocalDateTime.parse("2017-01-15T09:32:50.303"));

		account.printStatement(System.out, new Console());
		
		}
}
