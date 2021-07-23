package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 *
 * @author surui
 * @date 2021/7/11 5:47 下午
 */
public class Solution99 {
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

    public void recoverTree(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        dfs(root, treeNodeList);
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < treeNodeList.size() - 1; i++) {
            if (treeNodeList.get(i).val > treeNodeList.get(i + 1).val) {
                y = treeNodeList.get(i + 1);
                if (x == null) {
                    x = treeNodeList.get(i);
                }//1 2 3 7 5 6 4 8 9
            }

        }
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }

    }

    public void dfs(TreeNode treeNode, List<TreeNode> treeNodeList) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, treeNodeList);
        treeNodeList.add(treeNode);
        dfs(treeNode.right, treeNodeList);
    }
}


