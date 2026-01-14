package org.example.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    public int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int i = low, j = mid + 1;
        List<Integer> temp = new ArrayList<>();

        int start = mid + 1;
        for (int index = low ; index <= mid ; index++) {
            while (start <= high && (long)(arr[index]) > (2L * arr[start])) {
                start++;
            }

            count += (start - (mid + 1));
        }

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            } else {
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

    public int mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int count = 0;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 1, 2, 7};
        ReversePairs pairs = new ReversePairs();
        System.out.println(pairs.reversePairs(arr));
    }
}
