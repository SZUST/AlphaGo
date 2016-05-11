/**
 * @(#)Solution3.java   2016-5-11
 * Copyright 2016  wicloud.com, Inc. All rights reserved.
 */

package com.wicloud.alphago;

/**
 * Week-3 LeetCode 习题
 *
	3 Longest Substring Without Repeating Characters 22.1% Medium
	4 Median of Two Sorted Arrays 18.7% Hard
	5 Longest Palindromic Substring
	13 Roman to Integer 39.5% Easy
	14 Longest Common Prefix
 *
 * @author  wicloud
 * @date   2016-5-11
 */

public class Solution3 {

	/**
	 *  13. Roman to Integer
	 *  Given a roman numeral, convert it to an integer.
	 *  Input is guaranteed to be within the range from 1 to 3999.
	 *  罗马数字中I=1，V=5，X=10，L=50，C=100，D=500，M=1000
	 *  @param s
	 *  @return 
	 * 
		3999 / 3999 test cases passed.
		Status: Accepted
		Runtime: 8 ms
	    Your runtime beats 67.32% of javasubmissions
	 */

	public int romanToInt(String s) {
		if (0 == s.length()) {
			return 0;
		}
		char[] arr = s.toCharArray();
		int res = toInt(arr[arr.length - 1]);
		for (int i = arr.length - 1; i != 0; i--) {
			if (toInt(arr[i]) > toInt(arr[i - 1])) {
				res -= toInt(arr[i - 1]);
			} else {
				res += toInt(arr[i - 1]);
			}
		}
		return res;
	}

	private int toInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

}
