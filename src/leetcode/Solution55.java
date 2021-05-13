package leetcode;

import java.util.LinkedList;

/**
 * @author surui
 * @date 2021/4/25 11:58 下午
 */
public class Solution55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        LinkedList<TreeNode> temp;
        int result = 0;
        while (!queue.isEmpty()) {
            temp = new LinkedList();
            for (TreeNode treeNode : queue) {
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }
            result++;
            queue = temp;
        }
        return result;
    }
}
