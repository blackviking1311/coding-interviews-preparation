package org.example.datastructures.arrays;

public class NextPermutation {

    private void reverse(int[] arr, int low, int high) {
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int n = nums.length, index = n - 2;

        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        int j = n - 1;
        while (j > index) {
            if (nums[j] > nums[index]) {
                break;
            }
            j--;
        }

        swap(nums, index, j);
        reverse(nums, index + 1, n - 1);
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {1,3,2},
            {2,1,3}
        };

        NextPermutation permutation = new NextPermutation();
        for (int[] nums : arr) {
            permutation.nextPermutation(nums);
            for (int el : nums) {
                System.out.print(el + "  ");
            }

            System.out.println();
        }
    }
}
