package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author surui
 * @date 2021/5/11 10:47 下午
 */
public class Solution17 {
    private ArrayList<String> result = new ArrayList<>();
    private Map<Character, String> letterMap = new HashMap();

    public List<String> letterCombinations(String digits) {
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        //result = new ArrayList<>();
        if (digits.equals("")) {
            return result;
        }
        process(digits, 0, "");
        return result;
    }

    public void process(String digits, int index, String s) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letter = letterMap.get(c);
        for (int i = 0; i < letter.length(); i++) {
            process(digits, index + 1, s + letter.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("");
        System.out.println(strings);
    }
}
