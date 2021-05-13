package leetcode;

import java.util.HashSet;

/**
 * @author surui
 * @date 2020/12/13 9:42 PM
 */
public class Solution217 {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int num : nums) {
            integerHashSet.add(num);
        }
        return nums.length != integerHashSet.size();
    }
}
