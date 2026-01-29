package org.example.algorithms.recursion.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1498Subsequence {
    private int count = 0;

    private void combination(int[] arr, int index, List<Integer> current, int target) {
        if (index == arr.length) {
            int size = current.size();
            if (size != 0) {
                if (size == 1) {
                    if (current.get(0) + current.get(0) <= target) {
                        this.count++;
                    }
                } else {
                    if (current.get(0) + current.get(size - 1) <= target) {
                        this.count++;
                    }
                }
            }

            return;
        }

        current.add(arr[index]);
        this.combination(arr, index + 1, current, target);
        current.remove(current.get(current.size() - 1));
        this.combination(arr, index + 1, current, target);
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        this.combination(nums, 0, new ArrayList<>(), target);
        return this.count;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,6,8};
        int target = 10;

        Leetcode1498Subsequence solution = new Leetcode1498Subsequence();
        System.out.println(solution.numSubseq(arr, target));
    }
}
