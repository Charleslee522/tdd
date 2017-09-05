package money;

public abstract class Money {

	protected int amount;

	abstract Money times(int multiplier);
	
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
		return new Dollar(amount);
	}

	public static Money franc(int amount) {
		return new Franc(amount);
	}
	
}
