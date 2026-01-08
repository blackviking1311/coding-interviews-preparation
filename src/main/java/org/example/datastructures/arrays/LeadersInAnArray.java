package org.example.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {

    public List<Integer> leaders(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        if (nums.length == 1) return Collections.singletonList(nums[0]);

        int n = nums.length;
        int greatestRight = nums[n - 1];
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[n - 1]);

        for (int index = n - 2 ; index >= 0; index--) {
            if (nums[index] > greatestRight) {
                ans.add(nums[index]);
                greatestRight = nums[index];
            }
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 1, 2};
        LeadersInAnArray leaders = new LeadersInAnArray();
        for (int el : leaders.leaders(nums)) {
            System.out.print(el + " : ");
        }
    }
}
