package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author surui
 * @date 2021/1/24 11:08 AM
 */
public class Solution5662 {
    public static void main(String[] args) {
        minCharacters("aa", "bb");
    }

    public static int minCharacters(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        int alength = aChars.length;
        int blength = bChars.length;
        int x = 0;
        int shortCount = alength < blength ? alength : blength;
        char[] shortChars = alength < blength ? aChars : bChars;
        if ((alength == shortCount && (aChars[alength - 1] > bChars[blength - 1])) || (blength == shortCount && (bChars[blength - 1] > aChars[alength - 1]))) {
            for (char shortChar : shortChars) {
                if (shortChar != shortChars[shortCount - 1]) {
                    x++;
                }
            }
        } else {
            x = shortCount;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : aChars) {
            if (map.get(aChar) == null) {
                map.put(aChar, 1);
            } else {
                Integer integer = map.get(aChar);
                integer++;
                map.put(aChar, integer);
            }
        }
        for (char bChar : bChars) {
            if (map.get(bChar) == null) {
                map.put(bChar, 1);
            } else {
                Integer integer = map.get(bChar);
                integer++;
                map.put(bChar, integer);
            }
        }
        final Collection<Integer> values = map.values();
        Integer max = values.stream().sorted((o, u) -> o < u ? 1 : 0).findFirst().get();
        Integer sum = values.stream().reduce((f, s) -> f + s).get();
        int y = sum - max;
        return Math.min(x, y);
    }
}
