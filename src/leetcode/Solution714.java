package leetcode;

/**
 * @author surui
 * @date 2020/12/17 8:49 PM
 */
public class Solution714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        final int i = maxProfit(prices, 2);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int result = 0;
        for (int price : prices) {
            if (price > buy) {
                result += price - buy;
                buy = price;
            } else if (price + fee < buy) {
                buy = price + fee;
            }
        }
        return result;
    }
}
