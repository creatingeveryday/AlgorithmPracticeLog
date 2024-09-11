package com.habit.codingtest.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    @MethodSource
    static Stream<Arguments> caseArray() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("caseArray")
    void testContainsDuplicate(int[] input, boolean expected) {
        if (expected) {
            assertTrue(containsDuplicate(input));
        } else {
            assertFalse(containsDuplicate(input));
        }
    }
}