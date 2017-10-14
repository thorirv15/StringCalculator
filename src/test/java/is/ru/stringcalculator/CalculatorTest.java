package is.ru.stringcalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testStringContainingOneNumber() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testStringContainingTwoNumbers() {
		assertEquals(5, Calculator.add("2,3"));
	}

	@Test
	public void testStringContainingMultibleNumbers() {
		assertEquals(16, Calculator.add("2,3,10,1"));
	}

}