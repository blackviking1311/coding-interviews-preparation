package org.example.algorithms.binarysearch;

public class RotatedSortedArrays {

    public int search(int[] nums, int k) {
        int ans = -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == k) {
                return mid;
            }

            //  if the left part of the array is sorted
            if (nums[low] <= nums[mid]) {
                //  check if the target lies in this range or not
                if (k >= nums[low] && k < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //  if the right part of the array is sorted
                if (k > nums[mid] && k <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return ans;
    }

    public boolean searchInRotatedArraysPartTwo(int[] nums, int k) {
        boolean found = false;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == k) return true;

            while (low < high && nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }

            //  if the left part of the array is sorted
            if (nums[low] <= nums[mid]) {
                //  check if the target lies in this range or not
                if (k >= nums[low] && k < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //  if the right part of the array is sorted
                if (k > nums[mid] && k <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return found;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;

        RotatedSortedArrays sorted = new RotatedSortedArrays();
        System.out.println(sorted.search(nums, target));

        int[] nums2 = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target2 = 10;
        System.out.println(sorted.searchInRotatedArraysPartTwo(nums2, target2));
    }
}
