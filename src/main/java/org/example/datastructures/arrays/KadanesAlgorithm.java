package org.example.datastructures.arrays;

public class KadanesAlgorithm {

    public int maxSubArray(int[] nums)
    {
        int ans = 0, currSum = 0;
        for (int el : nums) {
            currSum += el;
            if (currSum >= ans) ans = currSum;
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        KadanesAlgorithm algorithm = new KadanesAlgorithm();
        int[] arr = {2, 3, 5, -2, 7, -4};
        System.out.println(algorithm.maxSubArray(arr));
    }
}
