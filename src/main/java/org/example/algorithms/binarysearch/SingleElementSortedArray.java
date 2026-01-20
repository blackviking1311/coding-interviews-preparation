package org.example.algorithms.binarysearch;

public class SingleElementSortedArray {

    public int findSingleElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];

        int n = nums.length;
        if (nums[n-1] != nums[n-2]) return nums[n - 1];

        int ans = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) low = mid + 1;
                else high = mid - 1;
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SingleElementSortedArray sortedArray = new SingleElementSortedArray();

        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(sortedArray.findSingleElement(arr));
    }
}
