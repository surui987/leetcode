package leetcode;

/**
 * 前缀和 hash
 *
 * @author surui
 * @date 2021/11/4 11:41 下午
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            if (nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int[] prenums = new int[nums.length + 1];
        int result = 0;
        prenums[0] = 0;
        for (int i = 1; i < prenums.length; i++) {
            prenums[i] = prenums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < prenums.length - 1; i++) {
            for (int j = i + 1; j < prenums.length; j++) {
                if (prenums[j] - prenums[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution560 solution = new Solution560();
        int[] nums = {-1, -1, 1};
        int i = solution.subarraySum(nums, 1);
        System.out.println(i);
    }
}
