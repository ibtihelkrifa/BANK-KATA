package com.sg.domain;

import java.io.PrintStream;
import java.time.LocalDateTime;

import com.sg.domain.Transaction.Type;

public class Account {

	private Statement statement;
	
	public Account(Statement statement) {
		this.statement = statement;
	}

	public void deposit(double amount, LocalDateTime now) {
		Transaction transaction = new Transaction(Type.DEPOSIT, amount, now);
		recordTransaction(transaction);
	}

	public void withdraw(double amount, LocalDateTime now ) {
		Transaction transaction = new Transaction(Type.WITHDRAW, -amount, now);
		recordTransaction(transaction);
	}

	private void recordTransaction(Transaction transaction) {
		this.statement.addStatementLine(transaction);
	}

	public void printStatement(PrintStream printer, Console console) {
		statement.printTo(printer, console);
	}
}
