package leetcode;

/**
 * @author surui
 * @date 2021/1/24 10:33 AM
 */
public class Solution5661 {
    public static void main(String[] args) {
        String time = "?4:03";
        final String s = maximumTime(time);
        System.out.println(s);
    }

    public static String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if (chars[1]=='?'||chars[1]<'4'){
                chars[0] = '2';
            }else {
                chars[0] = '1';
            }
        }
        if (chars[0] == '2') {
            if (chars[1] == '?') {
                chars[1] = '3';
            }
        } else {
            if (chars[1] == '?') {
                chars[1] = '9';
            }
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return new String(chars);
    }
}
