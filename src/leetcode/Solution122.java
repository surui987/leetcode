package leetcode;

/**
 * 差分
 *
 * @author surui
 * @date 2021/11/8 11:22 下午
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i + 1] - prices[i];
            if (diff[i] > 0) {
                max += diff[i];
            }
        }
        return max;
    }
}
