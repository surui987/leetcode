package leetcode;

import java.util.Stack;

/**
 * 字符串 基本计算器
 *
 * @author surui
 * @date 2021/11/13 11:06 上午
 */
public class Solution227 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (chars[i] != '+' && chars[i] != '-' && chars[i] != '*' && chars[i] != '/') {
                num = num * 10 + chars[i] - '0';
            } else if (sign == '+') {
                stack.push(num);
                sign = chars[i];
                num = 0;
            } else if (sign == '-') {
                stack.push(-num);
                sign = chars[i];
                num = 0;
            } else if (sign == '*') {
                stack.push(stack.pop() * num);
                sign = chars[i];
                num = 0;
            } else if (sign == '/') {
                stack.push(stack.pop() / num);
                sign = chars[i];
                num = 0;
            }
        }
        if (sign == '+') {
            stack.push(num);
        } else if (sign == '-') {
            stack.push(-num);
        } else if (sign == '*') {
            stack.push(stack.pop() * num);
        } else if (sign == '/') {
            stack.push(stack.pop() / num);
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution227 solution = new Solution227();
        int calculate = solution.calculate("3+5 / 2 ");
        System.out.println(calculate);
    }

}
