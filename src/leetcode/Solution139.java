package leetcode;

import java.util.*;

/**
 * BFS
 *
 * @author surui
 * @date 2021/11/14 11:16 下午
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //这里为了提高效率，把list转化为set，因为set的查找效率要比list高
        Set<String> setDict = new HashSet<>(wordDict);
        //记录当前层开始遍历字符串s的位置
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int length = s.length();

        boolean[] visited = new boolean[length];

        while (!queue.isEmpty()) {
            int index = queue.poll();
            //如果字符串到遍历完了，自己返回true
            if (index == length) {
                return true;
            }

            if (visited[index]) {
                continue;
            }
            //标记为访问过
            visited[index] = true;

            for (int i = index + 1; i <= length; i++) {
                if (setDict.contains(s.substring(index, i))) {
                    queue.add(i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution139 solution = new Solution139();
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        boolean result = solution.wordBreak("catsandog", Arrays.asList(wordDict));
        System.out.println(result);

    }
}
