package com.sg.domain;

import java.io.PrintStream;
import java.time.LocalDate;

import com.sg.domain.Transaction.Type;

public class Account {

	private Statement statement;
	private Console console;
	
	private double balance = 0;

	public Account(Statement statement, Console console) {
		this.statement = statement;
		this.console = console;
	}

	public void deposit(double amount, LocalDate now) {
		Transaction transaction = new Transaction(console, Type.DEPOSIT, amount, now);
		recordTransaction(transaction);
	}

	public void withdraw(double amount, LocalDate now ) {
		Transaction transaction = new Transaction(console, Type.WITHDRAW, -amount, now);
		recordTransaction(transaction);
	}

	private void recordTransaction(Transaction transaction) {
		this.balance = transaction.balanceAfterTransaction(balance);
		this.statement.addStatementLine(transaction, this.balance);
	}

	public void printStatement(PrintStream printer) {
		statement.printTo(printer, console);
	}
}
