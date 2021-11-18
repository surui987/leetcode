package leetcode;

/**
 * DFS
 *
 * @author surui
 * @date 2021/11/17 12:36 上午
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] result = get(root);
        return Math.max(result[0], result[1]);
    }

    public int[] get(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] result = new int[2];
        int[] left = get(root.left);
        int[] right = get(root.right);
        int max1 = Math.max(left[0] + right[1], left[0] + right[0]);
        int max2 = Math.max(left[1] + right[1], left[1] + right[0]);
        int tem1 = Math.max(max1, max2);
        int tem2 = root.val + left[0] + right[0];
        result[0] = tem1;
        result[1] = tem2;
        return result;
    }
}
