package com.petkap.calc.app.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringUtilTest {
	private StringUtil su = new StringUtil();

	private static Stream<Arguments> IandRforReverse() {
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

	private static Stream<Arguments> IandRforCreateArray() {
		return Stream.of(//
				Arguments.of(Arrays.asList("asd".toCharArray(), "a".toCharArray()),
						new char[][] { new char[] { 'a', 's', 'd' }, new char[] { 'a' } }), //
				Arguments.of(Arrays.asList("".toCharArray(), "".toCharArray()),
						new char[][] { new char[] {}, new char[] {} }), //
				Arguments.of(Arrays.asList("".toCharArray(), "a".toCharArray()),
						new char[][] { new char[] {}, new char[] { 'a' } }), //
				Arguments.of(Arrays.asList("a".toCharArray(), "".toCharArray()),
						new char[][] { new char[] { 'a' }, new char[] {} }) //
		);
	}

	private static Stream<Arguments> IandRforMakingRowsSameSize() {
		return Stream.of(//
				Arguments.of(Arrays.asList("asd", "a", "gf", "q", ""),
						Arrays.asList("asd", "a00", "gf0", "q00", "000")), //
				Arguments.of(Arrays.asList("asd", "aqq", "gfq", "qqq", "qqq"),
						Arrays.asList("asd", "aqq", "gfq", "qqq", "qqq")), //
				Arguments.of(Arrays.asList("asd"), Arrays.asList("asd")), //
				Arguments.of(Arrays.asList(""), Arrays.asList("")) //
		);
	}

	private static Stream<Arguments> IandRforZeroesString() {
		return Stream.of(//
				Arguments.of(0, ""), //
				Arguments.of(5, "00000"), //
				Arguments.of(10, "0000000000"), //
				Arguments.of(-1, ""), //
				Arguments.of(-5, ""), //
				Arguments.of(1, "0") //
		);
	}

	private static Stream<Arguments> IandRforAddZeroesToEnd() {
		return Stream.of(//
				Arguments.of("ab", -1, "ab"), //
				Arguments.of("ab0ba", -1, "ab0ba"), //
				Arguments.of("0023", -1, "0023"), //
				Arguments.of("549", -1, "549"), //
				Arguments.of("ab", 0, "ab"), //
				Arguments.of("ab0ba", 0, "ab0ba"), //
				Arguments.of("0023", 0, "0023"), //
				Arguments.of("549", 0, "549"), //
				Arguments.of("ab", 3, "ab0"), //
				Arguments.of("ab0ba", 6, "ab0ba0"), //
				Arguments.of("0023", 5, "00230"), //
				Arguments.of("549", 4, "5490"), //
				Arguments.of("ab", 5, "ab000"), //
				Arguments.of("ab0ba", 5, "ab0ba"), //
				Arguments.of("0023", 5, "00230"), //
				Arguments.of("549", 5, "54900"), //
				Arguments.of("549155", 5, "549155"), //
				Arguments.of("", 0, ""), //
				Arguments.of("", -1, ""), //
				Arguments.of("", 5, "00000") //
		);
	}

	private static Stream<Arguments> IandRforFindLongestRowSize() {
		return Stream.of(//
				Arguments.of(Arrays.asList("asdsaf", "grwgrw", "000000", "555555"), 6), //
				Arguments.of(Arrays.asList("a", "as", "asd", "asdf"), 4), //
				Arguments.of(Arrays.asList("a", "as", "asd", "asdf", "asd", "gf", "f"), 4), //
				Arguments.of(Arrays.asList("a", "as", "asd", "sdf"), 3), //
				Arguments.of(Arrays.asList("", "", ""), 0), //
				Arguments.of(Arrays.asList("a", "a", "f", "w"), 1) //
		);
	}

	@ParameterizedTest
	@MethodSource("IandRforReverse")
	void testReversingArray(String s, String result) {
		assertArrayEquals(result.toCharArray(), su.reverseArray(s.toCharArray()));
	}

	@ParameterizedTest
	@MethodSource("IandRforCreateArray")
	void testCreateArray(List<char[]> s, char[][] result) {
		assertTrue(Arrays.deepEquals(result, su.createArray(s)), "Arrays are not equals!");
	}

	@ParameterizedTest
	@MethodSource("IandRforMakingRowsSameSize")
	void testMakingRowsSameSize(List<String> s, List<String> result) {
		assertLinesMatch(result, su.makeRowsSameSize(s));
	}

	@ParameterizedTest
	@MethodSource("IandRforZeroesString")
	void testCreateZeroesString(int num, String result) {
		assertEquals(result, su.createZeroesString(num));
	}

	@ParameterizedTest
	@MethodSource("IandRforAddZeroesToEnd")
	void testAddingZeroesToEnd(String s, int startIndex, String result) {
		assertEquals(result, su.addZerosToEnd(s, startIndex));
	}

	@ParameterizedTest
	@MethodSource("IandRforFindLongestRowSize")
	void testFindLongestRowSize(List<String> list, int result) {
		assertEquals(result, su.findLongestRowSize(list));
	}

}
