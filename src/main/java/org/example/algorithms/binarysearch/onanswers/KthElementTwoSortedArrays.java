package org.example.algorithms.binarysearch.onanswers;

public class KthElementTwoSortedArrays {

    public int kthElement(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;
        if (n1 > n2) {
            return kthElement(b, a, k);
        }

        int left = k;   //  total elements I can have on the left hand side
        int low = Math.max(0, k - n2), high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = low + (high - low) / 2;  //  elements to be taken from the first array
            int mid2 = left - mid1;             //  remaining elements to be taken from the second array

            int l1 = mid1 - 1 >= 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >= 0 ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 < r2) {
                low = mid1 + 1;
            } else {
                high = mid1 - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
