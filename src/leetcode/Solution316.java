package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author surui
 * @date 2020/12/20 4:20 PM
 */
public class Solution316 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
        Deque<Character> stack = new ArrayDeque<>();
        stack.addLast('a');
        stack.addLast('b');
        System.out.println(stack.peekLast());
        System.out.println(stack.peek());
        for (Character character : stack) {
            System.out.println(character);
        }
    }

    public static String removeDuplicateLetters(String s) {
        int[] letterCount = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            letterCount[aChar - 'a']++;
        }
        int[] letterIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            letterIndex[chars[i] - 'a'] = i;
        }
        boolean[] existFlag = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.contains(chars[i])) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && letterIndex[stack.peekLast() - 'a'] > i) {
                existFlag[stack.peekLast() - 'a'] = false;
                stack.removeLast();
            }
            stack.addLast(chars[i]);
            existFlag[chars[i] - 'a'] = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : stack) {
            stringBuffer.append(character);
        }
        return stringBuffer.toString();
    }
}
