package com.petkap.calc.app.custom;

public class CustomNumberCalculator {
	private CustomNumber result;

	public CustomNumberCalculator(String n1, String n2) {
		CustomNumber c1 = new CustomNumber(n1);
		CustomNumber c2 = new CustomNumber(n2);

		result = c1.multiply(c2);
	}

	public CustomNumber getResult() {
		return result;
	}
}
