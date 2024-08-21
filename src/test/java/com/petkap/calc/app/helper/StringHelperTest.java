package com.petkap.calc.app.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringHelperTest {
	private static Stream<Arguments> inputsAndResults() {
		return Stream.of(//
				Arguments.of("aaa", "aaa"), //
				Arguments.of("aabbcc", "ccbbaa"), //
				Arguments.of("abcd", "dcba"), //
				Arguments.of("abcddcba", "abcddcba"), //
				Arguments.of("", ""), //
				Arguments.of("a0b1c2", "2c1b0a"), //
				Arguments.of("q", "q"), //
				Arguments.of("qwertyuiop", "poiuytrewq"), //
				Arguments.of("qazxswedcvfrtgbnhyujmkiolp", "ploikmjuyhnbgtrfvcdewsxzaq") //
		);
	}

	@ParameterizedTest
	@MethodSource("inputsAndResults")
	void testSimpleMultiplication(String s, String result) {
		var sh = new StringHelper();

		assertArrayEquals(result.toCharArray(), sh.reverseArray(s.toCharArray()));
	}
}
