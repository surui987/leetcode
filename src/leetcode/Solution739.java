package leetcode;

import java.util.Stack;

/**
 * @author surui
 * @date 2021/12/2 9:53 下午
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution739 solution = new Solution739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        solution.dailyTemperatures(temperatures);
    }
}
