package leetcode;

import java.util.Arrays;

/**
 * @author surui
 * @date 2021/12/2 7:33 下午
 */
public class SolutionOffer45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strs) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
