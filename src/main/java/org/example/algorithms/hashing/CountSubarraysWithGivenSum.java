package org.example.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {

    public int subarraySum(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int el : nums) {
            sum += el;
            int remainder = sum - k;

            if (sum == k) {
                ans++;
            }
            if (countMap.containsKey(remainder)) {
                ans += countMap.get(remainder);
            }

            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;

        CountSubarraysWithGivenSum countSubarray = new CountSubarraysWithGivenSum();
        System.out.println(countSubarray.subarraySum(arr, k));
    }
}
