package money;

import expression.Expression;
import expression.Sum;

public class Money implements Expression {

	public int amount;
	protected String currency;

	Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return this.amount == money.amount &&
				currency().equals(money.currency());
	}

	@Override
	public int hashCode() {
		return amount;
	}
	
	@Override
	public String toString() {
		return amount + " " + currency;
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	public static Money won(int amount) {
		return new Money(amount, "WON");
	}
	
	public String currency() {
		return this.currency;
	}

	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	@Override
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
}
