package com.sg.domain;

import java.io.PrintStream;

public class StatementLine {
	
	private Transaction transaction;
	
	public StatementLine(Transaction transaction) {
		this.transaction = transaction;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}
	
	public void printTo(PrintStream printer, Console console) {
		this.transaction.printTo(printer, console);
	}

}
