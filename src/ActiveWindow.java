/**
 * 滑动窗口
 *
 * @author surui
 * @date 2021/6/22 10:54 下午
 */
public class ActiveWindow {
    public static void main(String[] args) {
        String memory = "x..x..xx...";
        ActiveWindow activeWindow = new ActiveWindow();
        int maxFreeMemoryLen = activeWindow.getMaxFreeMemoryLen(memory, 2);
        System.out.println(maxFreeMemoryLen);
    }

    int getMaxFreeMemoryLen(String memory, int count) {
        int left = 0;
        int right = 0;
        int cost = 0;
        int result = 0;
        while (right < memory.length()) {
            char currentRight = memory.charAt(right);
            if (currentRight == 'x') {
                cost++;
            }
            while (cost > count) {
                char currentLeft = memory.charAt(left);
                if (currentLeft == 'x') {
                    cost--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
