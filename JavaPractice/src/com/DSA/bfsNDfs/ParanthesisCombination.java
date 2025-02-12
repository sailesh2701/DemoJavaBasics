package com.DSA.bfsNDfs;

import java.util.ArrayList;
import java.util.List;

public class ParanthesisCombination {
	public static void main(String args[]) {
		ParanthesisCombination pc = new ParanthesisCombination();
		System.out.println(pc.generateParenthesis(3));
		List<String> para = new ArrayList<>();
		System.out.println("--------------------\n Second Way Of implementation \n\n");
		pc.dfs(para, 0, 0, 3, "");
		System.out.println("--------------------\n\n\n" + para);
	}

	public static void generate(int open, int close, int n, ArrayList<String> ans, StringBuilder current) {
		if (open == n && close == n) {
			ans.add(current.toString());
			return;
		}
		if (open < n) {
			current.append('(');
			System.out.println("Before open++ " + open + " current " + current);
			generate(open + 1, close, n, ans, current);
			System.out.println("After open++ " + open + " current " + current);
			current.deleteCharAt(current.length() - 1); // String Builder is mutable if we don't remove it will continue
														// all the time with same characters
			System.out.println("delete open++ " + open + " current " + current);
		}
		if (close < open) {
			current.append(')');
			System.out.println("Before close++ " + close + " current " + current);
			generate(open, close + 1, n, ans, current);
			System.out.println("After close++ " + close + " current " + current);
			current.deleteCharAt(current.length() - 1);
			System.out.println("delete close++ " + close + " current " + current);
		}
	}

	// Method 2
	private void dfs(List<String> result, int open, int close, int n, String current) {
		if (open == n & close == n) {
			result.add(current);
			return;
		}

		if (open < n) {
			System.out.println("open < n current " + current);
			dfs(result, open + 1, close, n, current + "("); // String is immutable so no need to delete the character in
															// this case.
		}
		if (close < open) {
			System.out.println("close < open current " + current);
			dfs(result, open, close + 1, n, current + ")");
		}

	}

	public List<String> generateParenthesis(int n) {
		ArrayList<String> ans = new ArrayList();
		generate(0, 0, n, ans, new StringBuilder());
		return ans;
	}
}
