package com.DSA.Arrays;

import java.util.Stack;

public class NextGreaterElementInACircularArray {

	/**
	 * Given a circular integer array nums (i.e., the next element of
	 * nums[nums.length - 1] is nums[0]), return the next greater number for every
	 * element in nums.
	 * 
	 * The next greater number of a number x is the first greater number to its
	 * traversing-order next in the array, which means you could search circularly
	 * to find its next greater number. If it doesn't exist, return -1 for this
	 * number.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
	 * greater number is 2; The number 2 can't find next greater number. The second
	 * 1's next greater number needs to search circularly,
	 * 
	 * which is also 2.
	 * 
	 * 
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,2,3,4,3] Output: [2,3,4,-1,4]
	 **/

	public static void main(String[] args) {
		nextGreaterElements(new int[] { 5, 6, 3, 4, 3 });
	}

	public static void nextGreaterElements(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		for (int i = 0; i < n * 2; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
				arr[stack.pop()] = nums[i % n];
			}
			if (i < n) {
				stack.push(i);
			}
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
//		return arr;
	}

}
