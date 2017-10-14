package is.ru.stringcalculator;

public class Calculator {
	public static int add(String numbers) {
		if(numbers == "") {
			return 0;
		}

		int sum = 0;	
		String [] numberArr = numbers.split(",");
		if(numberArr.length > 1) {
			for(String s: numberArr) {
				sum += Integer.parseInt(s);
			}
			return sum;
		}

		return Integer.parseInt(numbers);
	}
}