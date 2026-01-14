package org.example.algorithms.binarysearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] ==  target) {
                ans[0] = mid;
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (ans[0] == -1) return ans;
        low = ans[0];
        high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;

        FirstAndLastPosition position = new FirstAndLastPosition();
        System.out.println(Arrays.toString(position.searchRange(arr, target)));
    }
}
