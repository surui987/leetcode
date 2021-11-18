package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和 hash
 *
 * @author surui
 * @date 2021/11/6 5:42 下午
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        int[] prenums = new int[nums.length + 1];
        prenums[0] = 0;
        for (int i = 1; i < prenums.length; i++) {
            prenums[i] = prenums[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prenums.length; i++) {
            int x = prenums[i] % k;
            if (map.get(x) == null) {
                map.put(x, i);
            } else {
                Integer index = map.get(x);
                if (i - index >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution523 solution = new Solution523();
        int[] nums = {23, 2, 4, 6, 6};
        boolean b = solution.checkSubarraySum(nums, 7);
        System.out.println(b);
    }
}
