package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和 hash
 *
 * @author surui
 * @date 2021/11/6 7:53 下午
 */
public class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0;
        int[] prenums = new int[nums.length + 1];
        prenums[0] = 0;
        for (int i = 1; i < prenums.length; i++) {
            prenums[i] = prenums[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prenums.length; i++) {
            int x = prenums[i] % k;
            if (x < 0) {
                x = max(x, k);
            }
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }
        for (Integer x : map.keySet()) {
            if (map.get(x) > 1) {
                result += kind(map.get(x));
            }
        }
        return result;
    }

    public int kind(int x) {
        if (x == 2) {
            return 1;
        }
        return kind(x - 1) + x - 1;
    }

    public int max(int x, int k) {
        while (x < 0) {
            x += k;
        }
        return x;
    }

    public static void main(String[] args) {
        Solution974 solution = new Solution974();
        /*int kind = solution.kind(5);
        System.out.println(kind);*/

        int[] nums = {-1, 2, 9};
        int i = solution.subarraysDivByK(nums, 2);
        System.out.println(i);
    }
}
