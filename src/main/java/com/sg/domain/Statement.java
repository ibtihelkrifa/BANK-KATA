package com.sg.domain;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Statement {

	  private static final String HEADER = "OPERATION | DATE | AMOUNT";
	  private List<StatementLine> statements = new ArrayList<StatementLine>();
	    
	    public void addStatementLine(Transaction transaction) {
	    	StatementLine statementLine = new StatementLine(transaction);
	    	statements.add(statementLine);
	    }
	    
	    public void printTo(PrintStream printer, Console console) {
			console.printLine(HEADER);
			printStatementLines(printer, console);
		}

		private void printStatementLines(PrintStream printer, Console console) {
			for (StatementLine statementLine : statements) {
				statementLine.printTo(printer, console);
			}
			console.printLine("BALANCE : " + calculateCurrentBalance());
		}
		

		private double calculateCurrentBalance() {
			double currentBalance = 0;
			for (StatementLine statementLine : statements) {
				currentBalance += statementLine.getTransaction().getAmount();
			}
			return currentBalance;
		}
}
