package com.petkap.calc.app.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CustomNumberTest {
	private CustomNumber cn = new CustomNumber();

	private static Stream<Arguments> IandRCalcPartRes() {
		return Stream.of(//
				Arguments.of(new char[] { '1', '2', '3' }, new char[] { '1', '2', '3' },
						Arrays.asList("123", "0246", "00369")), //
				Arguments.of(new char[] { '1' }, new char[] { '1' }, Arrays.asList("1")), //
				Arguments.of(new char[] { '5', '0' }, new char[] { '5', '0' }, Arrays.asList("52", "000")) //
		);
	}

	private static Stream<Arguments> IandRMultiplySD() {
		return Stream.of(//
				Arguments.of('0', '0', 0), //
				Arguments.of('1', '1', 1), //
				Arguments.of('5', '5', 25), //
				Arguments.of('2', '7', 14), //
				Arguments.of('2', '7', 14), //
				Arguments.of('2', '7', 14), //
				Arguments.of('9', '9', 81) //
		);
	}

	private static Stream<Arguments> IandRCalcRes() {
		return Stream.of(//
				Arguments.of(Arrays.asList("0012", "0023"), "5300"), //
				Arguments.of(Arrays.asList("001200", "002300"), "005300"), //
				Arguments.of(Arrays.asList("123", "321"), "444"), //
				Arguments.of(Arrays.asList("01230", "03210"), "04440"), //
				Arguments.of(Arrays.asList("1230", "3210"), "0444"), //
				Arguments.of(Arrays.asList("0123", "3210"), "3333"), //
				Arguments.of(Arrays.asList("0"), "0") //
		);
	}

	@ParameterizedTest
	@MethodSource("IandRCalcPartRes")
	void testCalculatePartialResults(char[] n1, char[] n2, List<String> res) {
		assertLinesMatch(res, cn.calculatePartialResults(n1, n2));
	}

	@ParameterizedTest
	@MethodSource("IandRMultiplySD")
	void testMultiplySimpleDigits(char n1, char n2, int res) {
		assertEquals(res, cn.multiplySimpleDigits(n1, n2));
	}

	@ParameterizedTest
	@MethodSource("IandRCalcRes")
	void testCalculateResult(List<String> list, String res) {
		assertEquals(res, cn.calculateResult(list));
	}

}
