package org.example.algorithms.binarysearch.onanswers;

public class MinimumDaysBouquets {

    private int numBouquets(int[] arr, int k, int days) {
        int count = 0;
        int c = 0;

        for (int el : arr) {
            if (el <= days) {
                c++;
            } else {
                c = 0;
            }

            if (c == k) {
                count++;
                c = 0;
            }
        }

        return count;
    }

    /**
     * Function to find the minimum days required to make M bouquets
     * @param n total number of roses
     * @param nums array where nums[i] denotes the number of days ith rose will take to bloom
     * @param k exact number of bloomed roses required for that bouquet
     * @param m number of bouquets to be made
     * @return the minimum number of days required to make the m bouquets and return -1 if not possible
     */
    public int roseGarden(int n, int[] nums, int k, int m) {
        int ans = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int el : nums) {
            min = Math.min(min, el);
            max = Math.max(max, el);
        }

        int low = min, high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int bouquets = numBouquets(nums, k, mid);

            if (bouquets < m) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumDaysBouquets bouquets = new MinimumDaysBouquets();
        int n = 8;
        int[] nums = {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2, k = 3;

        System.out.println(bouquets.roseGarden(n, nums, k, m));
    }
}
