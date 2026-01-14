package org.example.algorithms.binarysearch;

public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int el : row) if (el < 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
