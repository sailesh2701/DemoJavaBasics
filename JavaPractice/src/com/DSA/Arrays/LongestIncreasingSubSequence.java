package com.DSA.Arrays;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		/**
		 * Example 1:
		 * 
		 * Input: nums = [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
		 * increasing subsequence is [2,3,7,101], therefore the length is 4.
		 **/
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		/**
		 * Example 2:
		 * 
		 * Input: nums = [0,1,0,3,2,3] Output: 4
		 **/
		System.out.println(lengthOfLIS(new int[] { 0,1,0,3,2,3 }));
		/**
		 * Example 3:
		 * 
		 * Input: nums = [7,7,7,7,7,7,7] Output: 1
		 **/
		System.out.println(lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));
	}

	public static int lengthOfLIS(int[] nums) {
		int[] temp = new int[nums.length];
		int l = nums.length;
		/**
		 * Imagine all values will assuming themselves as they are starting point for
		 * increasing subsequence
		 **/
		for (int i = 0; i < l; i++)
			temp[i] = 1;

		for (int i = 1; i < l; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					temp[i] = Math.max(temp[i], temp[j] + 1);
			}
		}
		return Arrays.stream(temp).max().orElse(0);
	}

}
