package com.github.xuchen93;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author edwin
 */
@Slf4j
public class Demo {

	@SneakyThrows
	public static void main(String[] args) {
		System.out.println(new Demo().characterReplacement("AABABBA",1));
	}

	/*
	 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
	 * 总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。
	 * */
	public int characterReplacement(String s, int k) {
		int[] num = new int[26];
		int n = s.length();
		int maxn = 0;
		int left = 0, right = 0;
		while (right < n) {
			num[s.charAt(right) - 'A']++;
			maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
			if (right - left + 1 - maxn > k) {
				num[s.charAt(left) - 'A']--;
				left++;
			}
			right++;
		}
		return right - left;
	}
}
