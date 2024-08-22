package com.petkap.calc.app.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.petkap.calc.app.util.StringUtil;

public class CustomNumber {
	private String number;
	private StringUtil su = new StringUtil();

	public CustomNumber() {
	}

	public CustomNumber(String n) {
		number = n;
	}

	public CustomNumber multiply(CustomNumber n2) {
		// fix case when it's negative number
		var needToHandleN1 = number.startsWith("-");
		var needToHandleN2 = n2.getNumber().startsWith("-");
		var negResult = (needToHandleN1 && !needToHandleN2) || (!needToHandleN1 && needToHandleN2);

		var handledN1 = needToHandleN1 ? number.substring(1) : number;
		var handledN2 = needToHandleN2 ? n2.getNumber().substring(1) : n2.getNumber();

		var cn1 = su.reverseArray(handledN1.toCharArray());
		var cn2 = su.reverseArray(handledN2.toCharArray());

		var partialRes = calculatePartialResults(cn1, cn2);
		var result = calculateResult(su.makeRowsSameSize(partialRes));

		return new CustomNumber(String.format("%s%s", negResult ? "-" : "", result));
	}

	/**
	 * Calculates partial results. Example: 123 * 123 will crate list which looks
	 * like this:<br>
	 * 123<br>
	 * 0246<br>
	 * 00369<br>
	 * Number cn1 is multiplied by every digit from cn2. Partial result means cn1 is
	 * multiplied by digit from cn2, where offset (num of zeroes at the beginning)
	 * is calculated based on position of digit from cn2.
	 *
	 * @param cn1 first number used for multiplication
	 * @param cn2 second number used for multiplication
	 * @return list of numbers
	 */
	protected List<String> calculatePartialResults(char[] cn1, char[] cn2) {
		List<String> res = new ArrayList<>();

		for (int i = 0; i < cn1.length; i++) {
			char num = cn1[i];
			var str = new StringBuilder();
			int onHold = 0;

			str.append(su.createZeroesString(i));

			for (int j = 0; j < cn2.length; j++) {
				int currValue = multiplySimpleDigits(cn2[j], num);
				str.append((currValue + onHold) % 10);
				onHold = (currValue + onHold) / 10;
			}

			if (onHold > 0) {
				str.append(onHold);
			}

			res.add(str.toString());
		}

		return res;
	}

	/**
	 * Multiplies number c1 and c2.
	 *
	 * @param c1 first number to use
	 * @param c2 second number to use
	 * @return multiplied value
	 */
	protected int multiplySimpleDigits(char c1, char c2) {
		var n1 = Character.getNumericValue(c1);
		var n2 = Character.getNumericValue(c2);

		return n1 * n2;
	}

	/**
	 * Goes through list of values and does addition for columns.
	 *
	 * @param partialRes list of partial results
	 * @return calculated value
	 */
	protected String calculateResult(List<String> partialRes) {
		char[][] pr = su.createArray(partialRes.stream().map(String::toCharArray).collect(Collectors.toList()));
		int onHold = 0;
		var res = new StringBuilder();

		for (int clm = 0; clm < pr[0].length; clm++) {
			int currClm = onHold;

			for (int row = 0; row < pr.length; row++) {
				currClm += Character.getNumericValue(pr[row][clm]);
			}

			res.append(currClm % 10);
			onHold = currClm / 10;
		}

		if (onHold > 0) {
			res.append(onHold);
		}

		return res.reverse().toString();
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return number;
	}
}
