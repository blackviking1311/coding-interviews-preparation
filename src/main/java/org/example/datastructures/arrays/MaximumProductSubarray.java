package org.example.datastructures.arrays;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int prodLeft = 1, prodRight = 1, n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < nums.length ; i++) {
            prodLeft = prodLeft * nums[i];
            prodRight = prodRight * nums[n - i - 1];

            max = Math.max(max, Math.max(prodLeft, prodRight));
            if (prodLeft == 0) prodLeft = 1;
            if (prodRight == 0) prodRight = 1;
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
