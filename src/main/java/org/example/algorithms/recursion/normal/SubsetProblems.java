package org.example.algorithms.recursion.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubsetProblems {
    private List<Integer> ans;

    public void findSubsets(int[] arr, int index, int currentSum) {
        if (index >= arr.length) {
            this.ans.add(currentSum);
            return;
        }

        findSubsets(arr, index + 1, currentSum + arr[index]);
        findSubsets(arr, index + 1, currentSum);
    }

    public List<Integer> subsetSums(int[] nums) {
        this.ans = new ArrayList<>();
        findSubsets(nums, 0, 0);
        return this.ans;
    }

    private List<List<Integer>> subsetsList;

    private void findSubsets(int[] arr, Stack<Integer> current, int index) {
        if (index >= arr.length) {
            this.subsetsList.add(new ArrayList<>(current));
            return;
        }

        current.push(arr[index]);
        this.findSubsets(arr, current, index + 1);
        current.pop();
        int pos = index + 1;
        while (pos < arr.length && arr[pos] == arr[index]) {
            pos++;
        }

        this.findSubsets(arr, current, index + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.subsetsList = new ArrayList<>();
        this.findSubsets(nums, new Stack<>(), 0);
        return subsetsList;
    }

    private List<List<Integer>> combinationSumResult;

    public void combinationSumResult(int[] arr, int index, Stack<Integer> current, int digits, int k, int target) {
        if (digits == k && target == 0) {
            this.combinationSumResult.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;
        if (digits >= k || index >= arr.length) return;

        current.push(arr[index]);
        combinationSumResult(arr, index + 1, current, digits++, k, target - arr[index]);
        current.pop();
        combinationSumResult(arr, index + 1, current, digits, k, target);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        //  code here
        combinationSumResult = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        combinationSumResult(arr, 0, new Stack<>(), 0, k, n);
        return combinationSumResult;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1};
        SubsetProblems problems = new SubsetProblems();
        System.out.println(problems.subsetSums(arr));
    }
}
