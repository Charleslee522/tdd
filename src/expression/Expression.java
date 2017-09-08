package expression;

import money.Bank;
import money.Money;

public interface Expression {

	public Money reduce(Bank bank, String to);
}
