package com.DSA.arrayHashMapProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 });
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> hs = new HashSet<>();
		for (int num : nums)
			hs.add(num);

		int longestSequence = 0;
		int length = 0;
		for (int num : hs) {
//			if (!hs.contains(num - 1)) {
				length = 1;

				while (hs.contains(num + length))
					length++;

				longestSequence = Math.max(longestSequence, length);
//			}
		}
		System.out.println(longestSequence);
		return longestSequence;
	}

}
