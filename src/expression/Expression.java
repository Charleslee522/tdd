package expression;

import money.Money;

public interface Expression {

	public Money reduce(String to);
}
