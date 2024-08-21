package com.petkap.calc.app.helper;

public class StringHelper {

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
}
