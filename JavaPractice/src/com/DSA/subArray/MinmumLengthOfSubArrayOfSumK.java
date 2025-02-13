package com.DSA.subArray;

public class MinmumLengthOfSubArrayOfSumK {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(minSubArrayLen(4, new int[] { 1, 4, 4 }));
		System.out.println(minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
	}

	public static int minSubArrayLen(int s, int[] a) {
		int l = a.length;
		int sum = 0;
		int arraylen = Integer.MAX_VALUE;
		int j = 0;
		int i = 0;
		// while (i < l) {
		for (i = 0; i < l; i++) {
			sum += a[i];
			// i++;
			while (sum >= s && j < l) {
				sum -= a[j];
				arraylen = Math.min(arraylen, i - j + 1);
				j++;
			}
		}
		return arraylen == Integer.MAX_VALUE ? 0 : arraylen;
	}
}
