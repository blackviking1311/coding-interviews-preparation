package org.example.algorithms.binarysearch.onanswers;

public class FindMedian {

    public double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        if (n1 > n2) {
            return median(arr2, arr1);
        }

        double ans = 0;
        int low = 0, high = n1;     //  from the first array the number of elements that we can take is from 0 to n
        int left = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;  //  mid1 for the first array
            int mid2 = left - mid1;             //  mid2 for the second array

            //  find the value of l1 and l2
            int l1 = (mid1 - 1) >= 0 ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1) >= 0 ? arr2[mid2 - 1] : Integer.MIN_VALUE;

            //  find the value of r1 and r2
            int r1 = mid1 < n1 ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
