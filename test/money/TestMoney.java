package money;

import org.junit.Test;
import org.junit.Assert;

public class TestMoney {
	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		Assert.assertEquals(new Dollar(10), five.times(2));
		Assert.assertEquals(new Dollar(15), five.times(3));
	}
	
	@Test
	public void testEquality() {
		Assert.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		Assert.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		Assert.assertTrue(Money.franc(5).equals(Money.franc(5)));
		Assert.assertFalse(Money.franc(5).equals(Money.franc(6)));
		Assert.assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	
	@Test
	public void testFrancMultiplication() {
		Money five = Money.franc(5);
		Assert.assertEquals(new Franc(10), five.times(2));
		Assert.assertEquals(new Franc(15), five.times(3));
	}
}
