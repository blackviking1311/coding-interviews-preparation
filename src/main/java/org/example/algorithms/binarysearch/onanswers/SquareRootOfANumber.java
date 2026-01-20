package org.example.algorithms.binarysearch.onanswers;

public class SquareRootOfANumber {

    public int floorSqrt(int n) {
        if (n <= 1) return n;

        int low = 1, high = n / 2;
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
