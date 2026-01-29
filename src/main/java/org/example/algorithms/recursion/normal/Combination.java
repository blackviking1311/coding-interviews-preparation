package org.example.algorithms.recursion.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Combination {

    private void performCombination(int[] arr, List<List<Integer>> ans, Stack<Integer> current, int index, int target) {
        if (index > arr.length || target < 0) return;
        if (index == arr.length) {
            if (target == 0) ans.add(new ArrayList<>(current));
            return;
        }

        current.push(arr[index]);
        performCombination(arr, ans, current, index, target - arr[index]);
        current.pop();
        performCombination(arr, ans, current, index + 1, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        performCombination(candidates, ans, new Stack<>(), 0, target);
        return ans;
    }

    private List<List<Integer>> ans = new ArrayList<>();
    private void performCombinationII(int[] arr, Stack<Integer> stack, int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        if (target < 0 || index >= arr.length) return;

        stack.push(arr[index]);
        performCombinationII(arr, stack, index + 1, target - arr[index]);
        stack.pop();
        int pos = index + 1;
        while (pos < arr.length && arr[pos] == arr[index]) pos++;

        index = pos;
        performCombinationII(arr, stack, index, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        performCombinationII(candidates, new Stack<>(), 0, target);
        return this.ans;
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        int[] arr = {2, 5, 2, 1, 2};
        int target = 5;

        for (List<Integer> integers : combination.combinationSum2(arr, target)) {
            for (int el : integers) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
