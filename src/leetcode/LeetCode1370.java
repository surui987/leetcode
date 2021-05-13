package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 * @author surui
 * @date 2020/11/25 11:46 PM
 */
public class LeetCode1370 {
    public static void main(String[] args) {
        String s = "aet";
        String result = sortString(s);
        System.out.println(result);
        char[] bucket = new char[26];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = (char) (i + 'a');
        }
        System.out.println(bucket);

        for (char c : bucket) {
            System.out.println(c + "=====" + Arrays.binarySearch(bucket, c));
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < bucket.length; i++) {
            map.put(bucket[i], i);
        }
        System.out.println(map);
    }

    public static String sortString(String s) {
        int[] bucket = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            bucket[aChar - 'a']++;
        }
        String result = "";
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] > 0) {
                    result = result + String.valueOf((char) (i + 'a'));
                    bucket[i]--;
                    index++;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (bucket[i] > 0) {
                    result = result + String.valueOf((char) (i + 'a'));
                    bucket[i]--;
                    index++;
                }
            }
        }
        return result;
    }
}
