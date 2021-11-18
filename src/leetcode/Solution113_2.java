package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 *
 * @author surui
 * @date 2021/11/17 11:13 下午
 */
public class Solution113_2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> item = new ArrayList<>();

    public static class TreeNode {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return result;
    }

    public void dfs(TreeNode root, int targetSum, int num) {
        if (root == null) {
            return;
        }
        num += root.val;
        item.add(root.val);
        if (num == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(item));
        }
        dfs(root.left, targetSum, num);
        dfs(root.right, targetSum, num);
        item.remove(item.size() - 1);
    }

    public static void main(String[] args) {

        Solution113_2.TreeNode treeNode5 = new Solution113_2.TreeNode(5);
        Solution113_2.TreeNode treeNode4 = new Solution113_2.TreeNode(4);
        Solution113_2.TreeNode treeNode11 = new Solution113_2.TreeNode(11);
        Solution113_2.TreeNode treeNode7 = new Solution113_2.TreeNode(7);
        Solution113_2.TreeNode treeNode2 = new Solution113_2.TreeNode(2);
        Solution113_2.TreeNode treeNode8 = new Solution113_2.TreeNode(8);
        Solution113_2.TreeNode treeNode13 = new Solution113_2.TreeNode(13);
        Solution113_2.TreeNode treeNode42 = new Solution113_2.TreeNode(4);
        Solution113_2.TreeNode treeNode52 = new Solution113_2.TreeNode(5);
        Solution113_2.TreeNode treeNode1 = new Solution113_2.TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode42;
        treeNode42.left = treeNode52;
        treeNode42.left = treeNode1;

        Solution113_2 solution113 = new Solution113_2();
        solution113.pathSum(treeNode5, 22);
    }
}
