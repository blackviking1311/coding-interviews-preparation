package org.example.datastructures.arrays;

public class SortZeroes {

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void sortZeroes(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (mid < right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, right);
                right--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        SortZeroes sortZeroes = new SortZeroes();
        int[] nums = {1, 0, 2, 1, 0};

        sortZeroes.sortZeroes(nums);

        for (int el : nums) {
            System.out.print(el + " : ");
        }
    }
}
