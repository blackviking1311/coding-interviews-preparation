package org.example.algorithms.recursion.normal;

public class SubsequenceProblems {
    private int count = 0;

    public void countSubsequence(int[] nums, int target, int index, int sum) {
        if (index > nums.length) return;
        if (index == nums.length) {
            if (sum == target) count++;
            return;
        }

        countSubsequence(nums, target, index + 1, sum + nums[index]);
        countSubsequence(nums, target, index + 1, sum);
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        countSubsequence(nums, k, 0, 0);
        return this.count;
    }

    private boolean check(int[] nums, int target, int index, int currentSum) {
        if (index > nums.length) {
            return false;
        }

        if (index == nums.length) {
            return currentSum == target;
        }

        return check(nums, target, index + 1, currentSum + nums[index]) ||
                check(nums, target, index + 1, currentSum);
    }

    public boolean checkSubsequenceSum(int[] nums, int k) {
        return check(nums, k, 0, 0);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 100;

        SubsequenceProblems solution = new SubsequenceProblems();
        System.out.println(solution.checkSubsequenceSum(arr, k));
    }
}
