package model.entities;

import model.exceptions.WithdrawException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws WithdrawException {
		if(balance < amount) {
			throw new WithdrawException("Withdraw error: Saldo insuficiente.");
		}
		else if(withdrawLimit < amount ) {
			throw new WithdrawException("Withdraw error: Saque superior ao limite da conta!");
		}
		else {
			balance -= amount;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		 sb.append("New balance: ");
		 sb.append(String.format("%.2f", balance));
		
		return sb.toString();
	}

}
