package leetcode;

/**
 * 二分查找
 *
 * @author surui
 * @date 2021/11/13 1:28 下午
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] item : matrix) {
            if (search(item, target)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(int[] item, int target) {
        int left = 0;
        int right = item.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (item[mid] == target) {
                return true;
            } else if (item[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution240 solution = new Solution240();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        boolean b = solution.searchMatrix(matrix, target);
        System.out.println(b);
    }
}
