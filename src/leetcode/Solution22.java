package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/7/13 12:10 上午
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, result);
        return result;
    }

    private void dfs(String str, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(str + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1, result);
        }
    }
}
