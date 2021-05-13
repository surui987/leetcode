package learning.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/5/7 10:26 下午
 */
public class Code02_PrintAllSubsquences {
    public static void main(String[] args) {
        List<String> abc = subs("abc");
        System.out.println(abc);
    }

    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, "");
        return ans;
    }

    public static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process1(str, index + 1, ans, no);
        String yes = path + String.valueOf(str[index]);
        process1(str, index + 1, ans, yes);
    }
}
