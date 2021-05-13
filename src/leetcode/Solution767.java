package leetcode;

/**
 * @author surui
 * @date 2020/11/30 11:29 PM
 */
public class Solution767 {
    public static void main(String[] args) {
        String s = "aaab";
        String string = reorganizeString(s);
        System.out.println(string);
    }

    public static String reorganizeString(String S) {
        char[] chars = S.toCharArray();
        int[] letters = new int[26];
        for (char aChar : chars) {
            letters[aChar - 'a']++;
        }
        int mid = S.length() / 2;
        int max = 0;
        char c = 'a';
        int location = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > max) {
                max = letters[i];
                c = (char) (i + 'a');
                location = i;
            }
        }
        if (S.length() % 2 == 0) {
            if (max > mid) {
                return "";
            }
        } else {
            if (max > mid + 1) {
                return "";
            }
        }
        int index = 0;
        char[] result = new char[S.length()];
        for (int i = 0; i < max; i++) {
            result[index] = c;
            letters[location]--;
            index += 2;
        }
        for (int i = 0; i < 26; i++) {
            while (letters[i] > 0) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                letters[i]--;
                index += 2;
            }
        }
        return new String(result);
    }
}
