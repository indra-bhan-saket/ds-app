package com.ds.app.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MarkAndToySortProblem {

	public static void main(String[] args) {
		List<Integer> expenditure = new ArrayList<Integer>();
		expenditure.add(10);
		expenditure.add(20);
		expenditure.add(30);
		expenditure.add(40);
		expenditure.add(50);
		//System.out.println(activityNotifications(expenditure, 3));
	}

	static int activityNotifications(int[] expenditure, int d) {;

    int notificationCount = 0;

    int[] data = new int[201];
    for (int i = 0; i < d; i++) {
        data[expenditure[i]]++;
    }

    for (int i = d; i < expenditure.length; i++) {

        double median = getMedian(d, data);

        if (expenditure[i] >= 2 * median) {
            notificationCount++;

        }

        data[expenditure[i]]++;
        data[expenditure[i - d]]--;

    }

    return notificationCount;

}

private static double getMedian(int d, int[] data) {
    double median = 0;
    if (d % 2 == 0) {
        Integer m1 = null;
        Integer m2 = null;
        int count = 0;
        for (int j = 0; j < data.length; j++) {
            count += data[j];
            if (m1 == null && count >= d/2) {
                m1 = j;
            }
            if (m2 == null && count >= d/2 + 1) {
                m2 = j;
                break;
            }
        }
        median = (m1 + m2) / 2.0;
    } else {
        int count = 0;
        for (int j = 0; j < data.length; j++) {
            count += data[j];
            if (count > d/2) {
                median = j;
                break;
            }
        }
    }
    return median;
}

}
