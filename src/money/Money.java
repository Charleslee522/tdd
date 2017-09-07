package money;

public class Money implements Expression {

	public int amount;
	protected String currency;

	Money times(int multiplier) {
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
	
	public String currency() {
		return this.currency;
	}

	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}
	
}
