package com.DSA.Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContinouseSubArrayRemainder {

	public static void main(String[] args) {
		// minimum length is 2
		// and sum of subArray elements needs to be multiple of k
		// 0 also consider as it is multiple of all elements.
		System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));// 5 - -
		System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 6 }, 7));
		System.out.println(checkSubarraySum(new int[] { 5, 0, 0, 0 }, 3));

	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> res = new HashMap<>();
		int len = nums.length;
		int sum = 0;
		res.put(0, -1);

		for (int i = 0; i < len; i++) {
			sum += nums[i];
			// if (sum == k)
			// return true;
			int rem = (k == 0) ? sum : sum % k;
			if (res.containsKey(rem)) {
				if (i - res.get(rem) > 1)
					return true;
			} else {
				res.put(rem, i);
			}

		}

		return false;
	}

}
