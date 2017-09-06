package money;

public class Dollar extends Money {
	
	public Dollar(int amount, String currency) {
		super(amount, currency);
	}

	public Dollar times(int multiplier) {
		return new Dollar(amount * multiplier, null);
	}
	
}
