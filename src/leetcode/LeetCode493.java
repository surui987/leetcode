package leetcode;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * @author surui
 * @date 2020/11/28 12:23 AM
 */
public class LeetCode493 {
    public static void main(String[] args) {
        int[] ints={1,3,2,3,1};
        int i = reversePairs(ints);
        System.out.println(i);
    }
    public static int reversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2*nums[j]){
                    result++;
                }
            }
        }
        return result;
    }
}
