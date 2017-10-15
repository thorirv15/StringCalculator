package is.ru.stringcalculator;

public class Calculator {

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

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

		if(numbers.startsWith("//")){
			splitter = numbers.substring(2, 3);
			numbers = numbers.substring(numbers.indexOf("\n") + 1, numbers.length());	
		}
		else {
			splitter = ",|\n";
		}

		return  numbers.split(splitter);
	}

	private static boolean inputIsValid(String numbers) {
		String [] numberArr = getSplittedString(numbers);
		boolean noNegNumber = true;
		String errorString = "";

		for(int i = 0; i < numberArr.length; i++) {
			if(toInt(numberArr[i]) < 0) {
				errorString += (numberArr[i] + ",");
				noNegNumber = false;
			} 
		}

		if(!noNegNumber) {
			String exceptionString = errorString.substring(0, errorString.length() - 1);
			throw new IllegalArgumentException("Negatives not allowed: " + exceptionString);
		}

		return noNegNumber;
	}

	public static int add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		}

		if(inputIsValid(numbers)){		
			int sum = getSum(numbers);
			return sum;
		}

		return 0;
	}
}