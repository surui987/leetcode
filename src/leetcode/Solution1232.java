package leetcode;

/**
 * @author surui
 * @date 2021/1/17 10:39 PM
 */
public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][1] - coordinates[i - 1][1]) * (coordinates[i - 1][0] - coordinates[i - 2][0]) != (coordinates[i - 1][1] - coordinates[i - 2][1]) * (coordinates[i][0] - coordinates[i - 1][0])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer integer = Integer.valueOf("003");
        String string = Integer.toString(integer, 2);
        System.out.println(string);
        final int i = Integer.parseInt("111", 2);
        System.out.println(i);
        System.out.println("=========");
        int a = 1;
        System.out.printf("%010d", a);
        //. 运行结果: 0001 (使用printf几乎完全兼容C语言输出格式,适合刷OJ用)

        String str = String.format("%04d", a);
        System.out.println(str);

    }
}
