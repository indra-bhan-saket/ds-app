package com.ds.app.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class App {

	public static void main(String[] args) {
		
		// 1110001 ans is 101111
		// 1110100110 Ans is 1001011
		// 1110100110 Ans is 1001010
	}

	public static String cipher(int k, String s) {
		char[] arr = s.toCharArray();
		Map<Integer, Character[]> map = new HashMap<Integer, Character[]>();
		int j = 0;
		while (j < k) {
			Character[] temp = new Character[arr.length - j];
			for (int i = j, l = 0; i < arr.length && l < temp.length; i++, l++) {
				if (i < k - 1) {
					arr[i] = '0';
				} else if (j == 0 && i == k - 1) {
					arr[i] = '1';
				}
				temp[l] = arr[i];
			}
			map.put(j, temp);
			j++;
		}

		char[] result = new char[arr.length - k + 1];
		for (Entry<Integer, Character[]> entry : map.entrySet()) {
			for (int i = 0; i < entry.getValue().length && i < result.length; i++) {
				if (entry.getKey() == 0) {
					result[i] = entry.getValue()[i];
				} else {
					result[i] = (result[i] ^ entry.getValue()[i]) == 1 ? '1' : '0';
				}
			}
		}
		return new String(result);
	}
	
	
	static String cipher1(int k, String s) {
		char[] result = new char[s.length() - k + 1];
		char[] arr = s.toCharArray();
		result[0] = s.charAt(0);
		int i;
		for (i = 1; i < k; i++) {
			result[i] = arr[i] == arr[i - 1] ? '0' : '1';
		}
		for (; i < arr.length - k + 1; i++) {
			if (arr[i] == arr[i - 1]) {
				result[i] = result[i - k];
			} else {
				result[i] = result[i - k] == '1' ? '0' : '1';
			}
		}
		return new String(result);
	}
	

}