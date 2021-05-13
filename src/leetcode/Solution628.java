package leetcode;

import java.util.Arrays;

/**
 * @author surui
 * @date 2021/1/20 12:40 AM
 */
public class Solution628 {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4};
        final int i = maximumProduct(nums);
        System.out.println(i);
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int num : nums) {
            if (num > 0) {
                count++;
                break;
            }
        }
        if (count > 0) {
            if (nums[0] * nums[1] > nums[nums.length - 2] * nums[nums.length - 3]) {
                return nums[nums.length - 1] * nums[0] * nums[1];
            } else {
                return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            }
        } else {
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }
    }
}
