package leetcode;

/**
 * @author surui
 * @date 2021/1/4 11:03 PM
 */
public class Solution0810 {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ints = floodFill(image, 1, 1, 2);
        System.out.println(ints);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        change(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void change(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor || image[i][j] == newColor) {
            return;
        }
        image[i][j] = newColor;
        change(image, i + 1, j, oldColor, newColor);
        change(image, i - 1, j, oldColor, newColor);
        change(image, i, j + 1, oldColor, newColor);
        change(image, i, j - 1, oldColor, newColor);

    }
}
