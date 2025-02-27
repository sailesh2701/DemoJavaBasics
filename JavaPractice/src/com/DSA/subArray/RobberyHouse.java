package com.DSA.subArray;

public class RobberyHouse {

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 7, 2, 9, 3, 1 }));
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 1, 2, 3 }));
	}

	public static int rob(int[] nums) {
		int[] rob = new int[nums.length];
		if (nums.length <= 1)
			return nums[0];
		rob[0] = nums[0];
		rob[1] = Math.max(nums[1], nums[0]);
		for (int i = 2; i < nums.length; i++) {
			rob[i] = Math.max(rob[i - 1], nums[i] + rob[i - 2]);
		}

		return rob[nums.length - 1];
	}

}
