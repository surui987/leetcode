package leetcode;

/**
 * 贪心算法
 *
 * @author surui
 * @date 2021/11/18 11:01 下午
 */
public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[i]) {
                continue;
            } else if (chars1[i] == 'x') {
                xy++;
            } else {
                yx++;
            }
        }
        if ((xy + yx) % 2 != 0) {
            return -1;
        }
        int i = xy / 2 + yx / 2;
        return i + xy % 2 + yx % 2;
    }
}