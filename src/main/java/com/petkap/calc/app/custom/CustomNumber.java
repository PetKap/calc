package com.petkap.calc.app.custom;

import java.util.ArrayList;
import java.util.List;

import com.petkap.calc.app.helper.StringHelper;

public class CustomNumber {
	private String number;

	public CustomNumber(String n) {
		number = n;
	}

	public CustomNumber multiply(CustomNumber n1) {
		var sh = new StringHelper();
		var cn1 = sh.reverseArray(number.toCharArray());
		var cn2 = sh.reverseArray(n1.getNumber().toCharArray());
		var res = new StringBuilder();
		List<StringBuilder> partialRes = new ArrayList<>();
		int onHold = 0;

		// 12345 * 12345
		// -----
		// 61725 offset 0
		// + 49380 offset 1
		// + 37035 offset 2
		// + 24690 offset 3
		// + 12345 offset 5

		return new CustomNumber(res.toString());
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return number;
	}
}
