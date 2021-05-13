package kmp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/3/19 9:05 PM
 */
public class Code02_TreeEqual {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    // 方法一暴力
    public static boolean containsTree1(Node big, Node small) {
        if (small == null) {
            return true;
        }
        if (big == null) {
            return false;
        }
        if (isSameValueStructure(big, small)) {
            return true;
        }
        return containsTree1(big.left, small.left) || containsTree1(big.right, small.right);
    }

    public static boolean isSameValueStructure(Node big, Node small) {
        if (big == null && small != null) {
            return false;
        }
        if (big != null && small == null) {
            return false;
        }
        if (big == null && small == null) {
            return true;
        }
        if (big.value != small.value) {
            return false;
        }
        return isSameValueStructure(big.left, small.left) && isSameValueStructure(big.right, small.right);
    }


    // 方法二
    public static boolean containsTree2(Node big, Node small) {
        if (small == null) {
            return true;
        }
        if (big == null) {
            return false;
        }
        List<String> bigList = preSerial(big);
        List<String> smallList = preSerial(small);
        String[] bigStr = new String[bigList.size()];
        for (int i = 0; i < bigList.size(); i++) {
            bigStr[i] = bigList.get(i);
        }
        String[] smallStr = new String[smallList.size()];
        for (int i = 0; i < smallList.size(); i++) {
            smallStr[i] = smallList.get(i);
        }
        return getIndexOf(bigStr, smallStr) != -1;
    }

    private static int getIndexOf(String[] bigStr, String[] smallStr) {
        if (bigStr == null || smallStr == null | bigStr.length < 1 || bigStr.length < smallStr.length) {
            return -1;
        }
        int x = 0;
        int y = 0;
        int[] next = getNextArray(smallStr);
        while (x < bigStr.length && y < smallStr.length) {
            if (isEqual(bigStr[x], smallStr[y])) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == smallStr.length ? x - y : -1;
    }

    public static void main(String[] args) {
        String[] s = {"a", "b", "a", "b", "a", "b", "a", "c", "b", "a"};
        int[] nextArray = getNextArray(s);
    }

    private static int[] getNextArray(String[] smallStr) {
        if (smallStr.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[smallStr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int curr = 0;
        while (i < next.length) {
            if (isEqual(smallStr[i - 1], smallStr[curr])) {
                next[i++] = ++curr;
            } else if (curr > 0) {
                curr = next[curr];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    private static boolean isEqual(String a, String b) {
        if (a == null && b == null) {
            return true;
        } else {
            if (a == null || b == null) {
                return false;
            } else {
                return a.equals(b);
            }
        }
    }

    private static List<String> preSerial(Node head) {
        List<String> ans = new ArrayList<>();
        pres(head, ans);
        return ans;

    }

    private static void pres(Node head, List<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }
}
