package money;

import expression.Expression;

public class Bank {
	Money reduce(Expression source, String to) {
		return source.reduce(this, to);
	}
	
	public void addRate(String from, String to, int rate) {
		
	}
}
