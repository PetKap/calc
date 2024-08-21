package com.petkap.calc.app;

import com.petkap.calc.app.bigint.BigIntCalculator;
import com.petkap.calc.app.custom.CustomNumberCalculator;

public class StartCalculation {
	private static final String BIGINT_CALC = "--bi";

	public static void main(String[] args) throws Exception {
		boolean corNumOfArgs = args.length == 2 || args.length == 3;

		if (!corNumOfArgs) {
			throw new Exception("Wrong number of arguments was provided!");
		}

		String arg1 = args.length > 2 ? args[0] : "";
		String num1 = arg1 != "" ? args[1] : arg1;
		String num2 = arg1 != "" ? args[2] : args[1];

		if (arg1 == BIGINT_CALC) {
			BigIntCalculator biCalc = new BigIntCalculator(num1, num2);
			System.out.println(biCalc.getResult());
		} else {
			CustomNumberCalculator cnCalc = new CustomNumberCalculator(num1, num2);
			System.out.println(cnCalc.getResult());
		}
	}

}
