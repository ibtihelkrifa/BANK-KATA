package com.sg.domain;

import java.io.PrintStream;

public class StatementLine {
	
	private Transaction transaction;
	private double currentBalance;
	
	public StatementLine(Transaction transaction, double currentBalance) {
		this.transaction = transaction;
		this.currentBalance = currentBalance;
	}
	
	public void printTo(PrintStream printer) {
		this.transaction.printTo(printer, currentBalance);
	}

}
