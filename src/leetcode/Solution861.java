package leetcode;

/**
 * @author surui
 * @date 2020/12/7 11:29 PM
 */
public class Solution861 {
    public static void main(String[] args) {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        int i = matrixScore(A);
        System.out.println(i);

    }

    public static int matrixScore(int[][] A) {
        for (int[] row : A) {
            if (row[0] == 0) {
                for (int i = 0; i < row.length; i++) {
                    if (row[i] == 0) {
                        row[i] = 1;
                    } else {
                        row[i] = 0;
                    }
                }
            }
            continue;
        }
        int length = A[0].length;
        for (int j = 1; j < length; j++) {
            if (get(j, A)) {
                corver(j, A);
            }
        }
        int sum = 0;
        for (int[] ints : A) {
            int subsum = 0;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != 0) {
                    subsum = subsum + (int) Math.pow(2, (ints.length - i - 1));
                }
            }
            sum += subsum;
        }
        return sum;
    }

    public static boolean get(int j, int[][] A) {
        int length = A.length;
        int mid = length / 2;
        int count1 = 0;
        for (int i = 0; i < A.length; i++) {
            int[] rows = A[i];
            if (rows[j] == 1) {
                count1++;
            }
        }
        if (count1 > mid) {
            return false;
        }
        return true;
    }

    public static void corver(int j, int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] rows = A[i];
            if (rows[j] == 1) {
                rows[j] = 0;
            } else {
                rows[j] = 1;
            }
        }
    }
}
