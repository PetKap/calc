package com.petkap.calc.app.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CustomNumberCalculatorTest {
	private static Stream<Arguments> inputsAndResults() {
		return Stream.of(//
				Arguments.of("0", "0", "0"), //
				Arguments.of("1000", "1000", "1000000"), //
				Arguments.of("100000", "100000", "10000000000"), //
				Arguments.of("-2147483648", "-2147483648", "4611686018427387904"), //
				Arguments.of("2147483648", "2147483648", "4611686018427387904"), //
				Arguments.of("-2147483648", "2147483648", "-4611686018427387904"), //
				Arguments.of("1234567890", "9876543210", "12193263111263526900"), //
				Arguments.of("-1234567890", "-9876543210", "12193263111263526900"), //
				Arguments.of("-1234567890", "9876543210", "-12193263111263526900"), //
				Arguments.of("12345678901234567890", "98765432109876543210",
						"1219326311370217952237463801111263526900"), //
				Arguments.of("-12345678901234567890", "-98765432109876543210",
						"1219326311370217952237463801111263526900"), //
				Arguments.of("-12345678901234567890", "98765432109876543210",
						"-1219326311370217952237463801111263526900"), //
				Arguments.of("123456789012345678901234567890", "123456789012345678901234567890",
						"15241578753238836750495351562536198787501905199875019052100"), //
				Arguments.of("-123456789012345678901234567890", "-123456789012345678901234567890",
						"15241578753238836750495351562536198787501905199875019052100"), //
				Arguments.of("-123456789012345678901234567890", "123456789012345678901234567890",
						"-15241578753238836750495351562536198787501905199875019052100")//
		);
	}

	@ParameterizedTest
	@MethodSource("inputsAndResults")
	void testSimpleMultiplication(String num1, String num2, String result) {
		CustomNumberCalculator cnc = new CustomNumberCalculator(num1, num2);
		CustomNumber res = new CustomNumber(result);

		assertEquals(res.getNumber(), cnc.getResult().getNumber(),
				String.format("Wrong calculation for: %s * %s.", num1, num2));
	}
}
