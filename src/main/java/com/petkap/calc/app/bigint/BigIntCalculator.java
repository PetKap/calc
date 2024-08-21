package com.petkap.calc.app.bigint;

import java.math.BigInteger;

public class BigIntCalculator {

	BigInteger result;

	public BigIntCalculator(String n1, String n2) {
		BigInteger b1 = new BigInteger(n1);
		BigInteger b2 = new BigInteger(n2);

		result = b1.multiply(b2);
	}

	public BigInteger getResult() {
		return result;
	}
}
