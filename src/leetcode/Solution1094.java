package leetcode;

/**
 * 差分
 *
 * @author surui
 * @date 2021/11/7 12:20 上午
 */
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        final int max = 1000;
        int[] diff = new int[max + 1];
        for (int[] trip : trips) {
            int num = trip[0];
            int startIndex = trip[1];
            int endIndex = trip[2];
            diff[startIndex] += num;
            diff[endIndex] -= num;
        }
        int count = 0;
        for (int i = 0; i < diff.length; i++) {
            count += diff[i];
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        Solution1094 solution = new Solution1094();
        boolean b = solution.carPooling(trips, 3);
        System.out.println(b);
    }
}
