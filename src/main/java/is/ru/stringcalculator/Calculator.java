package is.ru.stringcalculator;

public class Calculator {
	public static int add(String numbers) {
		// String numberArr = numbers.split(",");
		// if(numberArr.length() == 0) {
		// 	return 0;
		// }
		// if(numberArr)
		if(numbers == "") {
			return 0;
		}
		
		return Integer.parseInt(numbers);
	}
}