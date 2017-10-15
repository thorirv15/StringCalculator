package is.ru.stringcalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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

	@Test
	public void testStringNumbersSeperatedByNewlineAndCommas() {
		assertEquals(16, Calculator.add("2,3,10\n1"));
	}

	// @Rule
	// public ExpectedException thrown = ExpectedException.none(); 

 //    @Test
	// public void testStringWithNegNumbers() {
		
	// 	thrown.expect(IllegalArgumentException.class);
	// 	thrown.expectMessage("Negatives not allowed: -1, -4, -9");
	// 	Calculator.add("2, -1, -4, 3, 10\n1, -9");
		
	// }

	// @Test
	// public void testStringWithNegNumbers() {
	// 	try {
	// 		assertEquals(2, Calculator.add("2, -1, -4, 3, 10\n1, -9"));
	// 	}
	// 	catch (Exception e) {
	// 		assertEquals("Negatives not allowed: -1, -4, -9", e.getMessage());
	// 	}		
	// }

	@Test
	public void testIfnumbersAbove1000AreIgnored() {
		assertEquals(2, Calculator.add("1001,2"));
	}
}