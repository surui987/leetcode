package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/1/20 11:30 PM
 */
public class Solution1253 {
    public static void main(String[] args) {
        int upper = 5;
        int lower = 5;
        int[] colsum = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
        List<List<Integer>> listList = reconstructMatrix(upper, lower, colsum);
        System.out.println(listList.toString());
    }

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[] ints1 = new int[colsum.length];
        boolean[] booleans1 = new boolean[colsum.length];
        int[] ints2 = new int[colsum.length];
        boolean[] booleans2 = new boolean[colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            int item = colsum[i];
            if (item == 0) {
                ints1[i] = 0;
                booleans1[i] = true;
                ints2[i] = 0;
                booleans2[i] = true;
            } else if (item == 2) {
                ints1[i] = 1;
                booleans1[i] = true;
                ints2[i] = 1;
                booleans2[i] = true;
            }
        }
        int sum1 = 0;
        for (int i = 0; i < booleans1.length; i++) {
            boolean b = booleans1[i];
            if (b == true) {
                sum1 += ints1[i];
            }
        }
        int sum2 = 0;
        for (int i = 0; i < booleans2.length; i++) {
            boolean b = booleans2[i];
            if (b == true) {
                sum2 += ints2[i];
            }
        }
        if (sum1 > upper || sum2 > lower) {
            return new ArrayList<>();
        }
        int i1 = upper - sum1;
        for (int i = 0; i < booleans1.length; i++) {
            if (i1 <= 0) {
                break;
            }
            boolean b = booleans1[i];
            if (b == false) {
                ints1[i] = 1;
                booleans1[i] = true;
                booleans2[i] = true;
                i1--;
            }
        }
        if (i1 > 0) {
            return new ArrayList<>();
        }
        int i2 = lower - sum2;
        for (int i = 0; i < booleans2.length; i++) {
            if (i2 <= 0) {
                break;
            }
            boolean b = booleans1[i];
            if (b == false) {
                ints2[i] = 1;
                booleans2[i] = true;
                booleans1[i] = true;
                i2--;
            }
        }
        if (i2 > 0) {
            return new ArrayList<>();
        }
        for (boolean b : booleans1) {
            if (b == false) {
                return new ArrayList<>();
            }
        }
        for (boolean b : booleans2) {
            if (b == false) {
                return new ArrayList<>();
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        for (int i : ints1) {
            result1.add(i);
        }
        List<Integer> result2 = new ArrayList<>();
        for (int i : ints2) {
            result2.add(i);
        }
        result.add(result1);
        result.add(result2);
        return result;
    }
}
