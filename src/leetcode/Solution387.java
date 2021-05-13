package leetcode;

/**
 * @author surui
 * @date 2020/12/23 11:26 PM
 */
public class Solution387 {
    public static void main(String[] args) {
        String s = "aadadaad";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] letterCount = new int[26];
        for (char aChar : chars) {
            letterCount[aChar - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letterCount[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
