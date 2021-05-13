package leetcode;

import graph.Node;

import java.util.*;

/**
 * @author surui
 * @date 2021/5/12 11:27 下午
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        results.add(root.val);
        process(results, root);
        return results;
    }

    public void process(List<Integer> results, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            results.add(root.right.val);
            process(results, root.right);
        } else if (root.left != null) {
            results.add(root.left.val);
            process(results, root.left);
        }
        return;
    }

    // 宽度遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void bfs(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.right != null) {
                if (!set.contains(cur.right)) {
                    set.add(cur.right);
                    queue.add(cur.right);
                }
            } else if (cur.left != null) {
                if (!set.contains(cur.left)) {
                    set.add(cur.left);
                    queue.add(cur.left);
                }
            }

        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
