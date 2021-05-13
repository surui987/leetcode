package leetcode;

/**
 * @author surui
 * @date 2020/12/1 11:43 PM
 */
public class Solution34 {
    public static void main(String[] args) {
        int[] ints = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(ints, 8);
        System.out.println(result.toString());
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                } else {
                    last = i;
                }
            }
        }
        if (first != -1 && last == -1) {
            return new int[]{first, first};
        } else {
            return new int[]{first, last};
        }
    }
}
