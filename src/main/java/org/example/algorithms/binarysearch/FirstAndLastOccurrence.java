package org.example.algorithms.binarysearch;

public class FirstAndLastOccurrence {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        boolean found = false;
        int low = 0, high = nums.length - 1, foundPos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                found = true;
                foundPos = mid;
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (!found) return ans;
        ans[0] = foundPos;
        int lastRight = foundPos;
        low = foundPos + 1;
        high = nums.length - 1;
        foundPos = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                foundPos = mid;
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (foundPos == -1) {
            ans[1] = lastRight;
        } else {
            ans[1] = foundPos;
        }

        return ans;
    }

    public static void main(String[] args) {
        String input = "-24 -23 -23 -22 -21 -20 -18 -16 -16 -14 -14 -11 -11 -9 -9 -5 -4 -2 -1 0 1 1 3 3 4 5 6 6 6 7 8 10 13 14 15 15 16 18 21 23 23 23 23 24 24 25";
        String[] parts = input.split(" ");
        int[] arr = new int[parts.length];
        int index = 0;
        for (String part : parts) {
            arr[index++] = Integer.parseInt(part);
        }

        int target = 3;

        FirstAndLastOccurrence occurrence = new FirstAndLastOccurrence();
        for (int el : occurrence.searchRange(arr, target)) {
            System.out.print(el + " : ");
        }
    }
}
