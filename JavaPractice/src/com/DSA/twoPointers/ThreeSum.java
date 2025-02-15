package com.DSA.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, -1, 0, 1, 2, -1, -4, 3 };
		System.out.println(threeSum(nums));
		System.out.println(threeSum2(nums));
	}

	// method1
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return result;

		// Sort the array using QuickSort
		Arrays.sort(nums);
		int n = nums.length;

		// 3 Sum problem lets say a,b,c
		// Two-pointer approach
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // Skip duplicates for a
			// Skipping because with same b,c duplicate 'a' will cause a duplicate triplet
			int left = i + 1, right = n - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					while (left < right && nums[left] == nums[left + 1])
						left++;// Skip duplicates for b
					while (left < right && nums[right] == nums[right - 1])
						right--;// Skip duplicates for c

					left++;
					right--;
				} else if (sum < 0) {
					left++; // Need a bigger number
				} else {
					right--; // Need a smaller number
				}
			}
		}

		return result;
	}

	// method2
	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> uniqueTriplets = new HashSet<>();
		int n = nums.length;

		// Iterate through the array and fix one element
		for (int i = 0; i < n - 2; i++) {
			Set<Integer> seen = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int target = -nums[i] - nums[j];
				if (seen.contains(target)) {
					List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
					Collections.sort(triplet); // Sort just the triplet to handle duplicates
					uniqueTriplets.add(triplet); // add to set.
				}
				seen.add(nums[j]);
			}
		}

		result.addAll(uniqueTriplets); // add to list
		return result;
	}

}
