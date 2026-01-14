package org.example.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    public int longestSubarray(int[] nums, int k) {
        int longestSubarray = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            currSum = currSum + nums[i];
            if (currSum == k) {
                longestSubarray = Math.max(longestSubarray, i + 1);
            }

            int rem = currSum - k;
            if (map.containsKey(rem)) {
                longestSubarray = Math.max(longestSubarray, i - map.get(rem));
            }

            if (!map.containsKey(currSum)) {
                map.put(currSum, i);
            }
        }

        return longestSubarray;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        LongestSubarrayWithSumK subarray = new LongestSubarrayWithSumK();
        System.out.println(subarray.longestSubarray(arr, k));
    }
}
