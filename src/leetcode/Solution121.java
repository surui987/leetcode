package leetcode;

/**
 * 差分
 *
 * @author surui
 * @date 2021/11/7 11:46 下午
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2};
        Solution121 solution = new Solution121();
        int i = solution.maxProfit(prices);
        System.out.println(i);
    }
}
