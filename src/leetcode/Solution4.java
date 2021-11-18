package leetcode;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author surui
 * @date 2021/11/13 11:53 下午
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nums1[i];
        }
        for (int i = nums1.length; i < res.length; i++) {
            res[i] = nums2[i - nums1.length];
        }
        Arrays.sort(res);
        if (res.length % 2 == 0) {
            return (Double.valueOf(res[res.length / 2]) + Double.valueOf(res[res.length / 2 - 1])) / 2;
        } else {
            return Double.valueOf(res[res.length / 2]);
        }
    }
}
