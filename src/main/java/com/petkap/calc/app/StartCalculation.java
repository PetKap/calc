package com.petkap.calc.app;

import com.petkap.calc.app.bigint.BigIntCalculator;
import com.petkap.calc.app.custom.CustomNumberCalculator;

public class StartCalculation {
	private static final String BIGINT_CALC = "--bi";
	private static final String CUSNUM_CALC = "--cn";

	public static void main(String[] args) throws Exception {
		boolean corNumOfArgs = args.length == 3;

		if (!corNumOfArgs) {
			throw new Exception("Wrong number of arguments was provided!");
		}

		if (args[0].equals(BIGINT_CALC)) {
			BigIntCalculator biCalc = new BigIntCalculator(args[1], args[2]);
			System.out.println(biCalc.getResult());
		} else if (args[0].equals(CUSNUM_CALC)) {
			CustomNumberCalculator cnCalc = new CustomNumberCalculator(args[1], args[2]);
			System.out.println(cnCalc.getResult());
		} else {
			throw new Exception("Wrong arguments provided!");
		}
	}

}
