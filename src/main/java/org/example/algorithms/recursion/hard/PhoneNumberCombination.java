package org.example.algorithms.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination {
    private List<String> ans;

    public PhoneNumberCombination() {
        this.ans = new ArrayList<>();
    }

    public void combine(String digits, int index, String current, String[] map) {
        if (index == digits.length()) {
            this.ans.add(current);
            return;
        }

        if (index > digits.length()) return;

        int number = Integer.parseInt(String.valueOf(digits.charAt(index)));
        if (number == 0 || number == 1) return;

        for (char ch : map[number].toCharArray()) {
            combine(digits, index + 1, current + ch, map);
        }
    }

    public List<String> letterCombinations(String digits) {
        //  always re-initializes the answers list (for online platforms)
        this.ans = new ArrayList<>();
        String[] map = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combine(digits, 0, "", map);
        return this.ans;
    }

    public static void main(String[] args) {
        String digits = "34";
        PhoneNumberCombination combination = new PhoneNumberCombination();

        for (String string : combination.letterCombinations(digits)) {
            System.out.println(string);
        }
    }
}
