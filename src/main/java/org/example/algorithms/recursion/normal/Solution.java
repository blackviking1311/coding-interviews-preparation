package org.example.algorithms.recursion.normal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0, count = 0;
        hashMap.put(0, 1);

        for (int el : nums) {
            sum += el;
            int rem = sum - k;

            if (hashMap.containsKey(rem)) {
                count += hashMap.get(rem);
            }

            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3,1,2,4};
        int s = 6;

        System.out.println(sol.subArraySum(arr, s));
    }
}
