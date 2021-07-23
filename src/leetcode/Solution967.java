package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度遍历
 *
 * @author surui
 * @date 2021/6/23 9:36 下午
 */
public class Solution967 {
    List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Solution967 solution = new Solution967();
        int[] ints = solution.numsSameConsecDiff(3, 7);
    }

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            DFS(stringBuffer, n, k);
        }
        int[] ints = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            ints[i] = resultList.get(i);
        }
        return ints;
    }

    public void DFS(StringBuffer curr, int n, int k) {
        if (curr.length() == n) {
            resultList.add(Integer.parseInt(curr.toString()));
            return;
        }
        char c = curr.charAt(curr.length() - 1);
        int currNum = c - '0';
        for (int i = 0; i < 10; i++) {
            if (Math.abs(currNum - i) == k) {
                curr.append(i);
                DFS(curr, n, k);
                curr.delete(curr.length() - 1, curr.length());
            }
        }
    }
}
