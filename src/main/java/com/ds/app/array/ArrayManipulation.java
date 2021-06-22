package com.ds.app.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayManipulation {

	public static void main(String[] args) {
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		for (int i = 0; i < 3; i++) {
			List<Integer> row = new ArrayList<Integer>();
			arr.add(i, row);
		}
		arr.get(0).add(0, 2);
		arr.get(0).add(1, 3);
		arr.get(0).add(2, 603);

		arr.get(1).add(0, 1);
		arr.get(1).add(1, 1);
		arr.get(1).add(2, 286);

		arr.get(2).add(0, 4);
		arr.get(2).add(1, 4);
		arr.get(2).add(2, 882);
		// System.out.println(arrayManipulation(4, arr));
		System.out.println(arrayManipulationOptimized(4, arr));
	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		int arr[] = new int[n + 1];
		long max = Long.MIN_VALUE;
		for (List<Integer> list : queries) {
			int start = list.get(0);
			int end = list.get(1);
			while (start <= end) {
				arr[start] = arr[start] + list.get(2);
				if (max < arr[start]) {
					max = arr[start];
				}
				start++;
			}
		}
		return max;
	}

	public static long arrayManipulationOptimized(int n, List<List<Integer>> queries) {
		int arr[] = new int[n + 1];
		long max = Long.MIN_VALUE;
		for (List<Integer> list : queries) {
			int start = list.get(0);
			int end = list.get(1);
			arr[start - 1] += list.get(2);
			arr[end] -= list.get(2);

		}
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + arr[i];
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}

}
