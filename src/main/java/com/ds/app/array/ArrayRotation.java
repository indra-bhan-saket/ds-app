package com.ds.app.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayRotation {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		rotLeft(list, 4);
	}

	public static List<Integer> rotLeft(List<Integer> a, int d) {
		int[] arr = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			arr[i] = a.get(i);
		}

		for (int i = 0; i < d; i++) {
			int temp = arr[0];
			int j = 0;
			for (; j < a.size() - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[j] = temp;
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			result.add(arr[i]);
		}
		return result;
	}
}
