package com.petkap.calc.app;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StartCalculationTest {
	private static Stream<Arguments> workingIAndR() {
		return Stream.of(//
				Arguments.of("--bi", "12345", "12345"), //
				Arguments.of("--cn", "12345", "12345") //
		);
	}

	@ParameterizedTest
	@MethodSource("workingIAndR")
	public void startCalculationWorkingTest(String a1, String a2, String a3) {
		assertDoesNotThrow(() -> StartCalculation.main(new String[] { a1, a2, a3 }));
	}

	@Test
	public void startCalculationNotWorkingTestWithoutArgs() {
		String[] args = new String[] {};

		assertThrows(Exception.class, () -> StartCalculation.main(args));
	}

	@Test
	public void startCalculationNotWorkingTestOneArg() {
		String[] args = new String[] { "--br" };

		assertThrows(Exception.class, () -> StartCalculation.main(args));
	}

	@Test
	public void startCalculationNotWorkingTestTooManyArgs() {
		String[] args = new String[] { "--br", "12345", "12345", "asdf" };

		assertThrows(Exception.class, () -> StartCalculation.main(args));
	}
}
