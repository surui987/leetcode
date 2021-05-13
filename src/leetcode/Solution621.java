package leetcode;

/**
 * @author surui
 * @date 2020/12/5 10:00 PM
 */
public class Solution621 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        int i = leastInterval(tasks, 2);
        System.out.println(i);
    }

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] results = new int[tasks.length * n];
        int[] letters = new int[26];
        for (char task : tasks) {
            letters[task - 'A']++;
        }
        int max = 0;
        for (int letterCount : letters) {
            max = max > letterCount ? max : letterCount;
        }
        int result = (max - 1) * (n + 1);

        for (int letterCount : letters) {
            if (letterCount == max) {
                result++;
            }
        }
        return Math.max(result, tasks.length);
    }
}
