package is.ru.stringcalculator;

public class Calculator {
	public static int add(String numbers) {
		if(numbers == "") {
			return 0;
		}

		int sum = 0;	
		String [] numberArr = numbers.split(",");
		if(numberArr.length == 2) {
				sum = Integer.parseInt(numberArr[0]) 
					+ Integer.parseInt(numberArr[1]);
								
			return sum;
		}

		return Integer.parseInt(numbers);
	}
}