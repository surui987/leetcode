package leetcode;

/**
 * @author surui
 * @date 2020/12/3 10:54 PM
 */
public class Solution204 {
    public static void main(String[] args) {
        int i = countPrimes(10);
        System.out.println(i);
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
