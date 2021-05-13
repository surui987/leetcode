package leetcode;

/**
 * @author surui
 * @date 2021/5/12 9:20 下午
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return compare(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean compare(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return compare(root.left, min, root.val) && compare(root.right, root.val, max);
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
