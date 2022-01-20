package com.sg.domain;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Statement {

	  private static final String HEADER = "OPERATION | DATE | AMOUNT | BALANCE";
	  private List<StatementLine> statementLines = new ArrayList<StatementLine>();
	    
	    public void addStatementLine(Transaction transaction, double currentBalance) {
	    	StatementLine statementLine = new StatementLine(transaction, currentBalance);
	    	statementLines.add(statementLine);
	    }
	    
	    public void printTo(PrintStream printer, Console console) {
			console.printLine(HEADER);
			printStatementLines(printer);
		}

		private void printStatementLines(PrintStream printer) {
			for (StatementLine statementLine : statementLines) {
				statementLine.printTo(printer);
			}
		}
}
