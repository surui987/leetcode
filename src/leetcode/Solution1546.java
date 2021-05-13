package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author surui
 * @date 2021/1/21 10:57 PM
 */
public class Solution1546 {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 5, 1, 4, 2, -9};
        int target = 6;
        maxNonOverlapping(nums, target);
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        int size = nums.length;
        int ret = 0;
        int i = 0;
        while (i < size) {
            Set<Integer> set = new HashSet<Integer>() {{
                add(0);
            }};
            int sum = 0;
            while (i < size) {
                sum += nums[i];
                if (set.contains(sum - target)) {
                    ret++;
                    break;
                } else {
                    set.add(sum);
                    i++;
                }
            }
            i++;
        }
        return ret;
    }
}
