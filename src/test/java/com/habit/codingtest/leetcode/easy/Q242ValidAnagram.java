package com.habit.codingtest.leetcode.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings s and t, return true if t is an
 * anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * using all the original letters exactly once.
 */
public class Q242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = map.getOrDefault(c, 0);
            if (count == 0) return false;
            map.put(c, count - 1);
        }

        return true;
    }

    public boolean isAnagramHashTable(String s, String t) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for(int val : count) {
            if(val != 0) {
                return false;
            }
        }
        return true;
    }

    @MethodSource
    static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    void test1(String s, String t, boolean expected) {
        if (expected) {
            assertTrue(isAnagram(s, t));
        } else {
            assertFalse(isAnagram(s, t));
        }
    }

    @ParameterizedTest
    @MethodSource("testCase")
    void test2(String s, String t, boolean expected) {
        if (expected) {
            assertTrue(isAnagramHashTable(s, t));
        } else {
            assertFalse(isAnagramHashTable(s, t));
        }
    }
}