package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author surui
 * @date 2020/12/25 11:35 PM
 */
public class Solution455 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        final int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        Deque<Integer> gs = new ArrayDeque<>();
        Deque<Integer> ss = new ArrayDeque<>();
        for (int i : g) {
            gs.addLast(i);
        }
        for (int j : s) {
            ss.addLast(j);
        }
        while (!gs.isEmpty() && !ss.isEmpty()) {
            Integer gi = gs.peekFirst();
            Integer sj = ss.peekFirst();
            if (sj >= gi) {
                result++;
                ss.removeFirst();
                gs.removeFirst();
            }else {
                ss.removeFirst();
            }
        }
        return result;
    }
}
