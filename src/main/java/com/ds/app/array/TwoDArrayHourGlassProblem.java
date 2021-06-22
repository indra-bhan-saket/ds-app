package com.ds.app.array;

import java.util.ArrayList;
import java.util.List;

public class TwoDArrayHourGlassProblem {

	public static void main(String[] args) {

		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		for (int i = 0; i < 6; i++) {
			List<Integer> row = new ArrayList<Integer>();
			arr.add(i, row);
		}
		arr.get(0).add(0, -9);
		arr.get(0).add(1, -9);
		arr.get(0).add(2, -9);
		arr.get(0).add(3, 1);
		arr.get(0).add(4, 1);
		arr.get(0).add(5, 1);

		arr.get(1).add(0, 0);
		arr.get(1).add(1, -9);
		arr.get(1).add(2, 0);
		arr.get(1).add(3, 4);
		arr.get(1).add(4, 3);
		arr.get(1).add(5, 2);

		arr.get(2).add(0, -9);
		arr.get(2).add(1, -9);
		arr.get(2).add(2, -9);
		arr.get(2).add(3, 1);
		arr.get(2).add(4, 2);
		arr.get(2).add(5, 3);

		arr.get(3).add(0, 0);
		arr.get(3).add(1, 0);
		arr.get(3).add(2, 8);
		arr.get(3).add(3, 6);
		arr.get(3).add(4, 6);
		arr.get(3).add(5, 0);

		arr.get(4).add(0, 0);
		arr.get(4).add(1, 0);
		arr.get(4).add(2, 0);
		arr.get(4).add(3, -2);
		arr.get(4).add(4, 0);
		arr.get(4).add(5, 0);

		arr.get(5).add(0, 0);
		arr.get(5).add(1, 0);
		arr.get(5).add(2, 1);
		arr.get(5).add(3, 3);
		arr.get(5).add(4, 4);
		arr.get(5).add(5, 0);

		System.out.println(hourglassSum(arr));
		//Ans should be 28
	}

	public static int hourglassSum(List<List<Integer>> arr) {
		int m = arr.size();
		int n = arr.size();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < m - 2; i++) {
			for (int j = 0; j < n - 2; j++) {

				int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1)
						+ arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
				if (max < sum) {
					max = sum;
				}

			}
		}
		return max;
	}

}
