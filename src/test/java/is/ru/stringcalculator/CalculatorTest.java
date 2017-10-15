package is.ru.stringcalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import junit.framework.Assert;


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

	@Test
	public void testStringWithOneNegNumber() {
	    try {
			assertEquals(1, Calculator.add("-1,2"));
		}
		catch (Exception e) {
			assertEquals("Negatives not allowed: -1", e.getMessage());
		}
	}

	@Test
	public void testStringWithMoreThenOneNegNumbers() {
	    try {
			assertEquals(-4, Calculator.add("2,-4,3,-5"));
		}
		catch (Exception e) {
			assertEquals("Negatives not allowed: -4,-5", e.getMessage());
		}
	}

	@Test
	public void testIfnumbersAbove1000AreIgnored() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testIfnumbersEqualTo1000AreNotIgnored() {
		assertEquals(1002, Calculator.add("1000,2"));
	}

	@Test
	public void testInputstringWithDifferentDelimeter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testInputstringWithDifferentDelimeterOfLength4() {
		assertEquals(3, Calculator.add("//;;;;\n1;2"));
	}
}