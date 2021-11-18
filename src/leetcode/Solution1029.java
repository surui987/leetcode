package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 *
 * @author surui
 * @date 2021/8/29 6:41 下午
 */
public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o2[1] - o2[0]) - Math.abs(o1[1] - o1[0]);
            }
        });
        int n = costs.length / 2;
        int countA = 0;
        int countB = 0;
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            int next = costs[i][0] - costs[i][1];
            if (countA < n && countB < n) {
                if (next > 0) {
                    sum += costs[i][1];
                    countB++;

                } else {
                    sum += costs[i][0];
                    countA++;
                }
                continue;
            }
            if (countA == n) {
                sum += costs[i][1];
                countB++;
                continue;
            }
            if (countB == n) {
                sum += costs[i][0];
                countA++;
                continue;
            }

        }
        return sum;
    }
}
