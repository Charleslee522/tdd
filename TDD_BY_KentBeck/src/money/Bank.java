package money;

import java.util.Hashtable;

import expression.Expression;
import mapping.Pair;

public class Bank {
	
	private Hashtable<Pair, Integer> rates = new Hashtable<Pair, Integer>();
	
	Money reduce(Expression source, String to) {
		return source.reduce(this, to);
	}
	
	public void addRate(String from, String to, int rate) {
		rates.put(new Pair(from, to), new Integer(rate));
	}
	
	public int rate(String from, String to) {
		if(from.equals(to)) return 1;
		Integer rate = (Integer) rates.get(new Pair(from, to));
		return rate.intValue();
	}
}
