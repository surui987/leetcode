package leetcode.leetcode20210110;

/**
 * @author surui
 * @date 2021/1/10 10:39 AM
 */
public class Solution5649 {
    public static void main(String[] args) {
        int[] encoded = {1,2,3};
        int first = 1;
        int[] decode = decode(encoded, first);
        for (int i : decode) {
            System.out.println(i);
        }
    }

    public static int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        int item = first;
        arr[0] = first;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = encoded[i - 1] ^ item;
            item = arr[i];
        }
        return arr;
    }
}
