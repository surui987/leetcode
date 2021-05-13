package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/1/5 11:04 PM
 */
public class Solution830 {
    public static void main(String[] args) {
        List<List<Integer>> listList = largeGroupPositions("aaa");
        System.out.println(listList);
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> listList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; ) {
            int[] ints = new int[2];
            ints[0] = i;
            ints[1] = i;
            for (int j = i + 1; j < s.length(); ) {
                if (chars[i] == chars[j]) {
                    j++;
                    if (j >= s.length()) {
                        ints[1] = j - 1;
                        setList(listList, ints);
                        return listList;
                    }
                } else {
                    ints[1] = j - 1;
                    setList(listList, ints);
                    i = j;
                    break;
                }
            }
        }
        return listList;
    }

    private static void setList(List<List<Integer>> listList, int[] ints) {
        if (ints[1] - ints[0] >= 2) {
            List<Integer> integers = new ArrayList<>();
            integers.add(0, ints[0]);
            integers.add(1, ints[1]);
            listList.add(integers);
        }
    }
}
