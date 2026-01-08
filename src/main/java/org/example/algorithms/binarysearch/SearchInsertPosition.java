package org.example.algorithms.binarysearch;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int ans = -1;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int ans = -1;
        int low = 0, high = letters.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if ((int) letters[mid] > (int) target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans == -1 ? letters[0] : letters[ans];
    }

    public static void main(String[] args) {
        char[] chars = {'c', 'f', 'j'};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.nextGreatestLetter(chars, 'f'));
    }
}
