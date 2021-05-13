package leetcode;

/**
 * @author surui
 * @date 2020/12/29 11:12 PM
 */
public class Solution330 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 10};
        int i = minPatches(nums, 20);
        System.out.println(i);
    }

    public static int minPatches(int[] nums, int n) {
        int count = 0;
        long max = 1;
        int index = 0;
        while (max < n) {
            if (index < nums.length && nums[index] <= max) {
                max = max + nums[index];
                index++;
            }else {
                max = max + max;
                count++;
            }
        }
        return count;
    }
}
