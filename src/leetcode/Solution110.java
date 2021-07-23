package leetcode;


/**
 * @author surui
 * @date 2021/5/14 11:46 下午
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        int hr = height(root.right);
        if (hl >= 0 && hr >= 0 && Math.abs(hl - hr) <= 1) {
            return Math.max(hl, hr) + 1;
        } else {
            return -1;
        }

    }
}
