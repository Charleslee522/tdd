package money;

public class Money {

	protected int amount;

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
	
}
