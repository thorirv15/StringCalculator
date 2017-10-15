package is.ru.stringcalculator;

public class Calculator {

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static int getSum(String numbers) {
		int sum = 0;	
		String [] numberArr = numbers.split(",|\n");
		
		if(numberArr.length > 1) {
			for(String s: numberArr) {
				if(toInt(s) < 1000){
					sum += toInt(s);
				}
			}
			return sum;
		}

		return toInt(numbers);
	}

	private static boolean validationForInput(String numbers) {
		String [] numberArr = numbers.split(",|\n");
		String [] invalidNumberArr = new String [numberArr.length];
		boolean isNegNumber = false;
		String errString = "";

		for(int i = 0; i < numberArr.length; i++) {
				if(toInt(numberArr[i]) < 0) {
					invalidNumberArr[i] = numberArr[i];
					errString += (invalidNumberArr[i] + ",");
					isNegNumber = true;
				} 
		}

		if(isNegNumber) {
			String errorString = errString.substring(0, errString.length() - 1);
			throw new IllegalArgumentException("Negatives not allowed:" + errorString);
		}

		return false;
	}

	public static int add(String numbers) {
		if(numbers.isEmpty()) {
				return 0;
		}

		if(!validationForInput(numbers)){
			
			int sum = getSum(numbers);

			return sum;
		}

		return 0;
	}
}