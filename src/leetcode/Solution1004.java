package leetcode;

/**
 * 滑动窗口
 *
 * @author surui
 * @date 2021/11/3 10:42 下午
 */
public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int start = 0;
        int lsum = 0;
        int rsum = 0;
        int max = 0;
        for (int end = 0; end < length; ++end) {
            rsum += 1 - nums[end];
            while (k < rsum - lsum) {
                lsum += 1 - nums[start];
                ++start;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1004 solution = new Solution1004();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int i = solution.longestOnes(nums, 2);
        System.out.println(i);
    }
}
