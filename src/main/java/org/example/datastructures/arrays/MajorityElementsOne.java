package org.example.datastructures.arrays;

public class MajorityElementsOne {

    public int majorityElements(int[] nums) {
        int count = 0, candidate = -1;
        for (int el : nums) {
            if (count == 0) {
                count = 1;
                candidate = el;
            } else if (candidate == el) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int el : nums)
            if (el == candidate) count++;

        if (count > nums.length / 2)
            return candidate;

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        MajorityElementsOne majorityElements = new MajorityElementsOne();
        System.out.println(majorityElements.majorityElements(nums));
    }
}
