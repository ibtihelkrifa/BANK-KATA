package com.sg.domain;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

	public enum Type implements Serializable {
		DEPOSIT, WITHDRAW;
	}

	private final Type type;
	private final double amount;
	private final LocalDate date;

	public Transaction(Type type, double amount, LocalDate now) {
		this.amount = amount;
		this.date = now;
		this.type = type;
	}

	public double balanceAfterTransaction(double balance) {
		return balance + amount;
	}

	public void printTo(PrintStream printer, Console console) {
		console.printLine(this.type.toString() + " | " + String.valueOf(date) + " | " + String.valueOf(amount) );
	}
	
	public double getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(date, other.date) && type == other.type;
	}

	

}
