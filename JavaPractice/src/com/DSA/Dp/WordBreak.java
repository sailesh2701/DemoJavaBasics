package com.DSA.Dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		wordBreak("catsandog", Arrays.asList("cats","tsa", "dog", "sand", "and", "cat"));
		wordBreak("leetcode", Arrays.asList("leet", "code"));
		wordBreak("applepenapple", Arrays.asList("apple", "pen"));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n];
	}

}
