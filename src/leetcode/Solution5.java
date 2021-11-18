package leetcode;

/**
 * 字符串
 *
 * @author surui
 * @date 2021/11/10 10:24 下午
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = getSame(s, i, i);
            String s2 = getSame(s, i, i + 1);
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }
        return result;
    }

    public String getSame(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        String result = solution.longestPalindrome("aacabdkacaa");
        System.out.println(result);
        String substring = "abc".substring(0, 1);
        System.out.println(substring);
    }
}
