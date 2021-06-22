package com.ds.app.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SherlockAndAnagram {

	public static void main(String[] args) {
		// System.out.println(sherlockAndAnagrams("abba"));
		System.out.println(sherlockAndAnagramsOptimized("cdcd"));
	}

	public static int sherlockAndAnagramsOptimized(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length() + 1; j++) {
				char[] charArray = s.substring(i, j).toCharArray();
				Arrays.sort(charArray);
				String sortedStr = new String(charArray);
				if (map.get(sortedStr) == null) {
					map.put(sortedStr, 0);
				}
				map.put(sortedStr, map.get(sortedStr) + 1);
			}
		}

		int counter = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			counter = counter + entry.getValue() * (entry.getValue() - 1) / 2;
		}

		return counter;
	}

	public static int sherlockAndAnagrams(String s) {
		List<String> list = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length() + 1; j++) {
				list.add(s.substring(i, j));
			}
		}
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (str.length() == list.get(j).length() && isAnagram(str, list.get(j))) {
					counter++;
					map.put(str, str);
				}
			}
		}
		return counter;
	}

	private static boolean isAnagram(String str1, String str2) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			if (map.get(str1.substring(i, i + 1)) == null) {
				map.put(str1.substring(i, i + 1), 0);
			}
			map.put(str1.substring(i, i + 1), map.get(str1.substring(i, i + 1)) + 1);
		}

		Map<String, Integer> map2 = new HashMap<String, Integer>();
		for (int i = 0; i < str2.length(); i++) {
			if (map2.get(str2.substring(i, i + 1)) == null) {
				map2.put(str2.substring(i, i + 1), 0);
			}
			map2.put(str2.substring(i, i + 1), map2.get(str2.substring(i, i + 1)) + 1);
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (map2.get(entry.getKey()) == null || map2.get(entry.getKey()) != entry.getValue()) {
				return false;
			}
		}
		return true;
	}
}
