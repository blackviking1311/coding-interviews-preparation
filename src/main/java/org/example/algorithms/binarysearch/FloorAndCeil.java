package org.example.algorithms.binarysearch;

public class FloorAndCeil {

    public int getFloor(int[] arr, int target) {
        int n = arr.length;

        if (target < arr[0]) return -1;
        if (target > arr[n - 1]) return arr[n - 1];

        int ans = -1, low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target >= arr[mid]) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int getCeil(int[] arr, int target) {
        int n = arr.length;
        if (target > arr[n - 1]) {
            return -1;
        }

        if (target < arr[0]) {
            return arr[0];
        }

        int ans = -1, low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) return arr[mid];
            else if (target < arr[mid]) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int[] getFloorAndCeil(int[] nums, int x) {
        int[] ans = new int[2];
        ans[0] = getFloor(nums, x);
        ans[1] = getCeil(nums, x);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int target = 5;

        FloorAndCeil calculator = new FloorAndCeil();
        for (int el : calculator.getFloorAndCeil(arr, target)) {
            System.out.print(el + " : ");
        }
    }
}
