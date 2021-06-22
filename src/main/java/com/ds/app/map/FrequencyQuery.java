package com.ds.app.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQuery {

	public static void main(String[] args) throws Exception {
		List<List<Integer>> queries = new ArrayList<List<Integer>>();

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\isaket\\Desktop\\input.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			List<Integer> second = new ArrayList<Integer>();
			String[] str = line.split(" ");
			second.add(Integer.parseInt(str[0]));
			second.add(Integer.parseInt(str[1]));
			queries.add(second);
		}
		br.close();
		System.out.println(freqQuery(queries));
	}

	static List<Integer> freqQuery(List<List<Integer>> queries) {
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < queries.size(); i++) {
			List<Integer> list = queries.get(i);
			if (list.get(0) == 1) {
				if (!data.containsKey(list.get(1))) {
					data.put(list.get(1), 1);
				} else {
					data.put(list.get(1), data.get(list.get(1)) + 1);
				}
			} else if (list.get(0) == 2) {
				if (data.get(list.get(1)) == null) {
					continue;
				}
				if (data.get(list.get(1)) <= 0) {
					data.remove(list.get(1));
				} else {
					data.put(list.get(1), data.get(list.get(1)) - 1);
				}
			} else if (list.get(0) == 3) {
				if (data.values().contains(list.get(1))) {
					result.add(1);
				} else {
					result.add(0);
				}
			}
		}
		return result;

	}

}
