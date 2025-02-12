package com.DSA.subArray;

import java.util.HashMap;
import java.util.Map;

public class ContinousSubArrayCount {
	public static void main(String args[]) {
		ContinousSubArrayCount c = new ContinousSubArrayCount();
		System.out.println(c.subarraySum(new int[] { 1, 2, 3, 4 }, 2));
	}

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> res = new HashMap<>();
		res.put(0, 1);
		int len = nums.length;
		int count = 0;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
			int rem = sum - k;// k-sum = 3-1 = 2
			if (res.containsKey(rem)) {
				count = count + res.get(rem);
			}
			res.put(sum, res.getOrDefault(sum, 0) + 1);
		}
		return count;
	}// [1,2,3,4,3,4,5,6,7,8,9,10] 10-7 = 3
}
