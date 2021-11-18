package leetcode;

/**
 * 字符串
 *
 * @author surui
 * @date 2021/1/13 12:19 AM
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int length2 = num2.length();
        int length = length1 + length2;
        int[] result = new int[length];
        int index = 1;
        for (int i = length1 - 1; i >= 0; i--) {
            int currIndex = length - index;
            index++;
            for (int j = length2 - 1; j >= 0; j--) {
                result[currIndex] += (char1[i] - '0') * (char2[j] - '0');
                result[currIndex - 1] += result[currIndex] / 10;
                result[currIndex] = result[currIndex--] % 10;
            }
        }
        String res = "";
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            } else {
                res += result[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);
    }
}
