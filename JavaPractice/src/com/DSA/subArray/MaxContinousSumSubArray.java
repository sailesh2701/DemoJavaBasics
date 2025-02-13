package com.DSA.subArray;

public class MaxContinousSumSubArray {
	public static void main(String args[]) {
//		MaxContinousSubArray m = new MaxContinousSubArray();
		System.out.println(maxSubArrayMethod1(new int[] { 1, 2, -1, -2 }));
		System.out.println(maxSubArrayMethod2(new int[] { 1, 2, -1, -2 }));

	}

	// method 2
	public static int maxSubArrayMethod2(int[] nums) {
		int l = nums.length;
		if (l == 0)
			return 0;

		int sum = nums[0];
		int currentSum = nums[0];

		for (int i = 1; i < l; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			sum = Math.max(currentSum, sum);
		}

		return sum;
	}

	// Method 1
	public static int maxSubArrayMethod1(int[] nums) {
		int l = nums.length;
		if (l == 0)
			return 0;
		int sum = 0;
		int max = nums[0];
		for (int i = 0; i < l; i++) {
			sum += nums[i];
			max = Math.max(sum, max);
			if (sum < 0)
				sum = 0;

		}
		return max;
	}
}
