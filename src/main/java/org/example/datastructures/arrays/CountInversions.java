package org.example.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    public long merge(int[] arr, int low, int mid, int high) {
        long count = 0;
        int i = low, j = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
                count += mid - i + 1;
                temp.add(arr[j++]);
            }
        }

        while (i <= mid) temp.add(arr[i++]);
        while (j <= high) temp.add(arr[j++]);

        i = low;
        for (int el : temp) {
            arr[i++] = el;
        }

        return count;
    }

    public long mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return 0;
        }

        long count = 0;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};
        CountInversions countInversions = new CountInversions();
        System.out.println(countInversions.numberOfInversions(nums));
    }
}
