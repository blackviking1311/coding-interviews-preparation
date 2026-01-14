package org.example.algorithms.binarysearch;

import java.util.*;

public class FindRightInterval {

    final static class Pair {
        int data;
        int index;

        public Pair(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    public int[] findRightInterval(int[][] intervals)
    {
        List<Pair> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0 ; i < intervals.length ; i++) {
            list.add(new Pair(intervals[i][0], i));
        }

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.data - o2.data;
            }
        });

        for (Pair pair : list) {
            System.out.println(pair.data + " : " + pair.index);
        }

        int[] a = new int[ans.size()];
        int index = 0;
        for (int el : ans) {
            a[index++] = el;
        }

        return a;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};
        FindRightInterval interval = new FindRightInterval();
        System.out.println(Arrays.toString(interval.findRightInterval(intervals)));
    }
}
