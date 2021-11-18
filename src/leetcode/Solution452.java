package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 *
 * @author surui
 * @date 2021/11/18 10:27 下午
 */
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution452 solution = new Solution452();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int i = solution.findMinArrowShots(points);
        System.out.println(i);
    }
}
