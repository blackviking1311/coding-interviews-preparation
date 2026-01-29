package org.example.algorithms.recursion.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ImplementationProblems {

    private double power(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;

        if (n % 2 == 0) {
            return this.power(x * x, n / 2);
        } else {
            return x * this.power(x, n - 1);
        }
    }

    public double myPow(double x, int n) {
        if ((long) n < 0) {
            return 1.0 / this.power(x, -1 * (long) n);
        }

        return this.power(x, n);
    }

    private void getParenthesis(int n, List<String> ans, int open, int close, String parenthesis) {
        if (open == n && close == n) {
            ans.add(parenthesis);
            return;
        }

        if (open < n) {
            this.getParenthesis(n, ans, open + 1, close, parenthesis + "(");
        }

        if (close < open) {
            this.getParenthesis(n, ans, open, close + 1, parenthesis + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        this.getParenthesis(n, ans, 0, 0, "");
        return ans;
    }

    private void powerSet(int[] nums, List<List<Integer>> ans, Stack<Integer> current, int currIndex) {
        if (currIndex >= nums.length) {
            List<Integer> copy = new ArrayList<>(current);
            ans.add(copy);
            return;
        }

        //  select the current element
        current.push(nums[currIndex]);
        powerSet(nums, ans, current, currIndex + 1);
        //  do not select the current element
        current.pop();
        powerSet(nums, ans, current, currIndex + 1);
    }

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        powerSet(nums, ans, stack, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ImplementationProblems problems = new ImplementationProblems();

        for (List<Integer> list : problems.powerSet(arr)) {
            for (int el : list) {
                System.out.print(el + " : ");
            }
            System.out.println();
        }
    }
}
