package com.DSA.Arrays;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubArraywithLengthK {
	/**
	 * Example 1:
	 * 
	 * Input: nums = [1,5,4,2,9,9,9], k = 3 Output: 15 Explanation: The subarrays of
	 * nums with length 3 are: - [1,5,4] which meets the requirements and has a sum
	 * of 10. - [5,4,2] which meets the requirements and has a sum of 11. - [4,2,9]
	 * which meets the requirements and has a sum of 15. - [2,9,9] which does not
	 * meet the requirements because the element 9 is repeated. - [9,9,9] which does
	 * not meet the requirements because the element 9 is repeated. We return 15
	 * because it is the maximum subarray sum of all the subarrays that meet the
	 * conditions
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [4,4,4], k = 3 Output: 0 Explanation: The subarrays of nums
	 * with length 3 are: - [4,4,4] which does not meet the requirements because the
	 * element 4 is repeated. We return 0 because no subarrays meet the conditions.
	 **/
	public static void main(String[] args) {
		System.out.println(maximumSubarraySum(new int[] { 1, 5, 4, 5, 9, 3, 9, 9 }, 3));
		System.out.println(maximumSubarraySum(new int[] { 4, 4, 4 }, 3));
		System.out.println(maximumSubarraySum(new int[] { 1, 1, 1, 7, 8, 9 }, 3));
		System.out.println(maximumSubarraySum(new int[] { 1, 1, 2 }, 2));
	}

	public static long maximumSubarraySum(int[] nums, int k) {
		Set<Integer> list = new HashSet<>();
		int l = nums.length;
		long currentSum = 0L;
		long maxSum = 0L;
		int j = 0;
		for (int i = 0; i < l; i++) {
			if (!list.contains(nums[i])) {
				currentSum += nums[i];
				list.add(nums[i]);
				if (i - j + 1 == k) {
					maxSum = Math.max(maxSum, currentSum);
					currentSum -= nums[j];
					list.remove(nums[j]);
					j++;
				}
			} else {
				while (nums[i] != nums[j]) {
					currentSum -= nums[j];
					list.remove(nums[j]);
					j++;
				}
				j++;
			}
		}
		return maxSum;
	}
}
