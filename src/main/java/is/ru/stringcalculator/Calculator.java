package is.ru.stringcalculator;

public class Calculator {

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static int getSum(String numbers) {
		int sum = 0;	
		String [] numberArr = numbers.split(",");
		
		if(numberArr.length > 1) {
			for(String s: numberArr) {
				sum += toInt(s);
			}
			return sum;
		}

		return toInt(numbers);
	}

	public static int add(String numbers) {
		if(numbers == "") {
			return 0;
		}

		int sum = getSum(numbers);

		return sum;
	}
}