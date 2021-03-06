package leetcode;

/**
 * 差分数组
 *
 * @author surui
 * @date 2021/6/23 11:48 下午
 */
public class Solution1109 {
    public static void main(String[] args) {
        Solution1109 solution = new Solution1109();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ints = solution.corpFlightBookings(bookings, 5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        int[] diff = new int[n + 1];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int size = booking[2];
            for (int i = first; i < last + 1; i++) {
                diff[i] += size;
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = diff[i + 1];
        }
        return result;
    }
    /*public int[] corpFlightBookings(int[][] bookings, int n) {
        int maxNum = n;
        *//*for (int[] booking : bookings) {
            int i = booking[2];
            maxNum = Math.max(i, maxNum);
        }*//*
        int[] resultOffset = new int[maxNum + 1];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int size = booking[2];
            resultOffset[first] += size;
            if (last < maxNum) {
                resultOffset[last + 1] -= size;
            }
        }
        int[] result = new int[maxNum + 1];
        for (int i = 1; i < result.length; i++) {
            result[i] = resultOffset[i] + result[i - 1];
        }
        int[] res = new int[maxNum];
        for (int i = 0; i < res.length; i++) {
            res[i] = result[i + 1];
        }
        return res;
    }*/
}
