package org.example.algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> integers = new HashSet<>();
        for (int el : nums) {
            integers.add(el);
        }

        for (int el : nums)
        {
            if (integers.contains((el + 1))) {
                continue;
            }

            int cons = 0, temp = el;
            while (integers.contains(temp)) {
                integers.remove(temp);
                cons++;
                temp--;
            }

            ans = Math.max(ans, cons);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutiveSequence consecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(consecutiveSequence.longestConsecutive(arr));
    }
}
