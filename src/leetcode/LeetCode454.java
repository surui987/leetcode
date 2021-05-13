package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author surui
 * @date 2020/11/27 12:06 AM
 */
public class LeetCode454 {
    public static void main(String[] args) {

    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> abMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                abMap.put(a + b, abMap.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                if (abMap.get(-c - d) != null) {
                    result = result + abMap.get(-c - d);
                }
            }
        }
        return result;
    }
}
