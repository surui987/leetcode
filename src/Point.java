/**
 * @author surui
 * @date 2021/3/6 10:21 PM
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private static void modifyPoint(Point p1, Point p2) {
        Point temp = p1;
        p1 = p2;
        p2 = temp;
        p1.setLocation(5, 5);
        //p2 = new Point(5, 5);
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        modifyPoint(p1, p2);
        System.out.println(p1.x + "," + p1.y + "," + p2.x + "," + p2.y);
        System.out.println(test2());
        System.out.println(test3());
    }

    public static int test2() {
        int a = 100;
        try {
            a = 200;
            return a;
        } finally {
            a = 300;
        }
    }

    public static int test3() {
        int a = 100;
        try {
            a = 200;
            return a;
        } finally {
            a = 300;
            return a;
        }
    }
}
