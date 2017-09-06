package money;

public abstract class Money {

	protected int amount;
	protected String currency;

	abstract Money times(int multiplier);
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return this.amount == money.amount &&
				getClass() == obj.getClass();
	}

	@Override
	public int hashCode() {
		return amount;
	}

	public static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Franc(amount, "CHF");
	}
	
	public String currency() {
		return this.currency;
	}
	
}
