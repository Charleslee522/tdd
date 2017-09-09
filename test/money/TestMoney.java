package money;

import org.junit.Test;

import expression.Expression;
import expression.Sum;

import org.junit.Assert;

public class TestMoney {
	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		Assert.assertEquals(Money.dollar(10), five.times(2));
		Assert.assertEquals(Money.dollar(15), five.times(3));
	}
	
	@Test
	public void testEquality() {
		Assert.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		Assert.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		Assert.assertTrue(Money.franc(5).equals(Money.franc(5)));
	}
		
	@Test
	public void testCurrency() {
		Assert.assertEquals("USD", Money.dollar(1).currency());
		Assert.assertEquals("CHF", Money.franc(1).currency());
		Assert.assertEquals("WON", Money.won(1).currency());
	}
	
	@Test
	public void testPlusReturnsSum() {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		Assert.assertEquals(five, sum.augend);
		Assert.assertEquals(five, sum.addend);
	}
	
	@Test
	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		Assert.assertEquals(Money.dollar(7), result);
	}

	@Test
	public void testReduceMoney() {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(3), "USD");
		Assert.assertEquals(Money.dollar(3), result);
	}
	
	@Test
	public void testReduceOtherCurrency() {
		Bank bank = new Bank();
		bank.addRate("USD", "CHF", 1);
		Money result = bank.reduce(Money.dollar(3), "CHF");
		Assert.assertEquals(Money.franc(3), result);
	}
	
	@Test
	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		Assert.assertEquals(Money.dollar(1), result);
	}
	
	@Test
	public void testArrayEquals() {
		Assert.assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
	}
	
	@Test
	public void testIdentityRate() {
		Assert.assertEquals(1, new Bank().rate("USD", "USD"));
	}
	
	@Test
	public void testMixedAddition() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		Assert.assertEquals(Money.dollar(10), result);
	}
	
	@Test
	public void testSumPlusMoney() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Expression thousandWon = Money.won(1000);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		bank.addRate("WON", "USD", 1000);
		Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks).plus(thousandWon);
		Money result = bank.reduce(sum, "USD");
		Assert.assertEquals(Money.dollar(16), result);
	}
	
	@Test
	public void testSumTime() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
		Money result = bank.reduce(sum, "USD");
		Assert.assertEquals(Money.dollar(20), result);
	}
	
}
