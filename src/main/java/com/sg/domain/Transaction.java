package com.sg.domain;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

	public enum Type implements Serializable {
		DEPOSIT, WITHDRAW;

		@Override
		public String toString() {
			switch (this) {
			case DEPOSIT:
				return "DEPOSIT";
			case WITHDRAW:
				return "WITHDRAW";
			default:
				return "";
			}
		}
	}

	private final Console console;
	private final Type type;
	private final double amount;
	private final LocalDate date;

	public Transaction(Console console, Type type, double amount, LocalDate now) {
		this.amount = amount;
		this.date = now;
		this.type = type;
		this.console = console;
	}

	public double balanceAfterTransaction(double balance) {
		return balance + amount;
	}

	public void printTo(PrintStream printer, double currentBalance) {
		console.printLine(this.type.toString() + " | " + String.valueOf(date) + " | " + String.valueOf(amount) + " | " + String.valueOf(currentBalance));
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
