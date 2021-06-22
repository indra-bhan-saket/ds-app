package com.ds.app.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplet {

	public static void main(String[] args) {

		List<Long> arr = new ArrayList<Long>();
		arr.add(1L);
		arr.add(4L);
		arr.add(16L);
		arr.add(64L);
		System.out.println("Triplet count=> " + countTriplets(arr, 4));
	}

	static long countTriplets(List<Long> arr, long r) {

		Map<Long, Long> potential = new HashMap<Long, Long>();
		Map<Long, Long> counter = new HashMap<Long, Long>();
		long count = 0;
		for (int i = 0; i < arr.size(); i++) {
			long a = arr.get(i);
			long key = a / r;

			if (counter.containsKey(key) && a % r == 0) {
				count += counter.get(key);
			}

			if (potential.containsKey(key) && a % r == 0) {
				long c = potential.get(key);
				if (counter.get(a) == null) {
					counter.put(a, 0L);
				}
				counter.put(a, counter.get(a) + c);
			}

			if (potential.get(a) == null) {
				potential.put(a, 0L);
			}

			potential.put(a, potential.get(a) + 1);
		}
		return count;

	}
}
