package org.example.datastructures.arrays;

public class RearrangeArrayElements {

    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;

        for (int num : nums) {
            if (num < 0) {
                ans[neg] = num;
                neg += 2;
            } else {
                ans[pos] = num;
                pos += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RearrangeArrayElements rearrange = new RearrangeArrayElements();
        int[] nums = {2, 4, 5, -1, -3, -4};
        for (int el : rearrange.rearrangeArray(nums)) {
            System.out.print(el + " : ");
        }
    }
}
