package leetcode;

import java.util.Stack;

/**
 * 单调栈
 *
 * @author surui
 * @date 2021/10/25 11:15 下午
 */
public class StockSpanner901 {
    Stack<Integer> prices;
    Stack<Integer> wrights;

    public StockSpanner901() {
        prices = new Stack<>();
        wrights = new Stack<>();
    }


    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += wrights.pop();
        }
        prices.push(price);
        wrights.push(w);
        return w;
    }
}
