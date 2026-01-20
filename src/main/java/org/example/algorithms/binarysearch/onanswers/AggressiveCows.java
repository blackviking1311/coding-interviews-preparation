package org.example.algorithms.binarysearch.onanswers;

import java.util.Arrays;

public class AggressiveCows {

    private int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] ans = {min, max};
        for (int el : arr) {
            min = Math.min(min, el);
            max = Math.max(max, el);
        }

        return new int[] {min, max};
    }

    private boolean canPlaceCows(int[] arr, int k, int distance) {
        int count = 1;
        int startPos = arr[0];

        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] - startPos >= distance) {
                count++;
                startPos = arr[i];
            }
        }

        return count >= k;
    }

    public int aggressiveCows(int[] nums, int k) {
        int[] minMax = findMinMax(nums);
        int low = 0, high = minMax[1], ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.canPlaceCows(nums, k, mid)) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5, k = 4;
        int[] nums = {0, 3, 4, 7, 10, 9};
        Arrays.sort(nums);

        AggressiveCows cows = new AggressiveCows();
        System.out.println(cows.aggressiveCows(nums, k));
    }
}
