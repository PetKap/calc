package com.petkap.calc.app;

import com.petkap.calc.app.bigint.BigIntCalculator;

public class StartCalculation {

	public static void main(String[] args) throws Exception {
		boolean corNumOfArgs = args.length == 2 || args.length == 3;

		if (corNumOfArgs) {
			String arg1 = args.length > 2 ? args[0] : "";
			String num1 = arg1 != "" ? args[1] : arg1;
			String num2 = arg1 != "" ? args[2] : args[1];

			BigIntCalculator biCalc = new BigIntCalculator(num1, num2);
			System.out.println(biCalc.getResult());

		}

		throw new Exception("Wrong number of arguments was provided!");
	}

}
