package com.petkap.calc.app.util;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

	/**
	 * Reverse elements in array.
	 *
	 * @param arr array, which will be reversed
	 * @return reversed array
	 */
	public char[] reverseArray(char arr[]) {
		int len2 = arr.length >> 1;
		char temp;

		for (int i = 0; i < len2; ++i) {
			temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}

		return arr;
	}

	/**
	 * Creates 2D array from list.
	 *
	 * @param list
	 * @return 2D array with same elements
	 */
	public char[][] createArray(List<char[]> list) {
		char[][] res = new char[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	/**
	 * Adds zeroes to end of String to make all rows same size.
	 *
	 * @param list list with String values, which we want to make same length
	 * @return updated list
	 */
	public List<String> makeRowsSameSize(List<String> list) {
		int size = findLongestRowSize(list);

		return list.stream().map(s -> addZerosToEnd(s, size)).collect(Collectors.toList());
	}

	/**
	 * Creates String from zeros.
	 *
	 * @param numOf number of zeros added to String
	 * @return String with zeros
	 */
	public String createZeroesString(int numOf) {
		var str = new StringBuilder();

		for (int i = 0; i < numOf; i++) {
			str.append("0");
		}

		return str.toString();
	}

	/**
	 * Adds zeros to end of provided String.
	 *
	 * @param s           String where zeros will be added
	 * @param totalLength expected length of String with zeros at the end
	 * @return String with zeros
	 */
	public String addZerosToEnd(String s, int totalLength) {
		var str = new StringBuilder(s);

		for (int i = s.length(); i < totalLength; i++) {
			str.append("0");
		}

		return str.toString();
	}

	/**
	 * Returns size of longest row in list.
	 *
	 * @param list list with String values
	 * @return size of longest row
	 */
	protected int findLongestRowSize(List<String> list) {
		int res = 0;

		for (String s : list) {
			if (res < s.length()) {
				res = s.length();
			}
		}

		return res;
	}
}
