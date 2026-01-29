package org.example.algorithms.recursion.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {

    private List<List<String>> ans;

    private boolean isPalindrome(String string) {
        int left = 0, right = string.length() - 1;

        while (left <= right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void performPartition(String string, int index, Stack<String> stack) {
        if (index >= string.length()) {
            this.ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index ; i < string.length() ; i++) {
            if (isPalindrome(string.substring(index, i + 1))) {
                stack.push(string.substring(index, index + 1));
                performPartition(string, i + 1, stack);
                stack.pop();
            }
        }
    }

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        performPartition(s, 0, new Stack<>());
        return this.ans;
    }

    public static void main(String[] args) {
        PalindromePartitioning partitioning = new PalindromePartitioning();
        String string = "aabaa";

        for (List<String> rows : partitioning.partition(string)) {
            for (String row : rows) {
                System.out.print(row + ",");
            }
            System.out.println();
        }
    }
}
