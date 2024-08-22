package com.petkap.calc.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.petkap.calc.app.bigint.BigIntCalculator;
import com.petkap.calc.app.custom.CustomNumberCalculator;

public class CalculationTest {
	private static Stream<Arguments> inputsAndResults() {
		return Stream.of(//
				Arguments.of("0", "0"), //
				Arguments.of("1000", "1000"), //
				Arguments.of("100000", "100000"), //
				Arguments.of("-2147483648", "-2147483648"), //
				Arguments.of("2147483648", "2147483648"), //
				Arguments.of("-2147483648", "2147483648"), //
				Arguments.of("1234567890", "9876543210"), //
				Arguments.of("-1234567890", "-9876543210"), //
				Arguments.of("-1234567890", "9876543210"), //
				Arguments.of("12345678901234567890", "98765432109876543210"), //
				Arguments.of("-12345678901234567890", "-98765432109876543210"), //
				Arguments.of("-12345678901234567890", "98765432109876543210"), //
				Arguments.of("123456789012345678901234567890", "123456789012345678901234567890"), //
				Arguments.of("-123456789012345678901234567890", "-123456789012345678901234567890"), //
				Arguments.of("-123456789012345678901234567890", "123456789012345678901234567890")//
		);
	}

	@ParameterizedTest
	@MethodSource("inputsAndResults")
	void testSimpleMultiplication(String num1, String num2) {
		CustomNumberCalculator cnc = new CustomNumberCalculator(num1, num2);
		BigIntCalculator bc = new BigIntCalculator(num1, num2);

		assertEquals(bc.getResult().toString(), cnc.getResult().getNumber().toString(),
				String.format("Calculation doesn't match: %s * %s.", num1, num2));
	}
}
