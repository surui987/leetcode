package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/5/6 10:09 下午
 */
public class Solution113 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode42 = new TreeNode(4);
        TreeNode treeNode52 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode42;
        treeNode42.left = treeNode52;
        treeNode42.left = treeNode1;

        Solution113 solution113 = new Solution113();
        solution113.pathSum(treeNode5, 22);
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
        list.add(root.val);
        if (num == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        dfs(root.left, targetSum, num);
        dfs(root.right, targetSum, num);
        list.remove(list.size() - 1);
    }


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
}
