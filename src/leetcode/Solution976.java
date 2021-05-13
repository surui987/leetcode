package leetcode;

import java.util.Arrays;

/**
 * @author surui
 * @date 2020/11/29 10:08 PM
 */
public class Solution976 {

    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            for (int j = i - 1; j > 0; j--) {
                if (A[j] + A[j - 1] > A[i]) {
                    return A[j] + A[j - 1] + A[i];
                }
            }
        }
        return 0;
    }
}
