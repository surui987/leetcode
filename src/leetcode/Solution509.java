package leetcode;

/**
 * @author surui
 * @date 2021/1/4 10:47 PM
 */
public class Solution509 {
    public static void main(String[] args) {
        int fib = fib(5);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
