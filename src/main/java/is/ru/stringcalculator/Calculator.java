package is.ru.stringcalculator;

public class Calculator {

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	// Calculates the total sum of all pos numbers below or equal to 1000.
	private static int getSum(String numbers) {
		int sum = 0;

		String [] numberArr = getSplittedString(numbers);
		
		if(numberArr.length > 1) {
			for(String s: numberArr) {
				if(toInt(s) <= 1000){
					sum += toInt(s);
				}
			}
			return sum;
		}

		return toInt(numbers);
	}

	private static String [] getSplittedString(String numbers) {
		String splitter = "";

		// If string starts with //, the splitter will become whatever symbol
		// is in pos right after the slashes, and the number string will be 
		// whatever comes after the first \n symbol.
		if(numbers.startsWith("//")){
			splitter = numbers.substring(2, 3);
			numbers = numbers.substring(numbers.indexOf("\n") + 1, numbers.length());	
		}
		else {
			// The splitter by default.
			splitter = ",|\n";
		}

		return  numbers.split(splitter);
	}

	private static boolean inputIsValid(String numbers) {
		String [] numberArr = getSplittedString(numbers);
		boolean noNegNumber = true;
		String errorString = "";

		// Loop through all numbers in the string to see if
		// there are any neg values.
		for(int i = 0; i < numberArr.length; i++) {
			if(toInt(numberArr[i]) < 0) {
				// If there are any neg numbers add them to the error string 
				// wich will be printed when exception is thrown.
				errorString += (numberArr[i] + ",");
				// If one neg number is found, noNegNumber becomes false.
				noNegNumber = false;
			} 
		}

		if(!noNegNumber) {
			// Groom errorString before exception is thrown.
			errorString = errorString.substring(0, errorString.length() - 1);
			throw new IllegalArgumentException("Negatives not allowed: " + errorString);
		}

		return noNegNumber;
	}

	public static int add(String numbers) {
		if(numbers.isEmpty()) {return 0;}

		// If validation(no neg numbers in string) checks out, 
		// the sum of the numbers will be returned.
		if(inputIsValid(numbers)) {return getSum(numbers);}

		return 0;
	}
}