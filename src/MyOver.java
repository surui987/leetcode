import java.util.ArrayList;
import java.util.List;

/**
 * @author surui
 * @date 2021/3/7 12:15 AM
 */
public class MyOver {
    public MyOver(int i) {

    }

    public static void main(String[] args) {
        MyOver myOver = new MyOver(10);
        int i = 9;
        switch (i) {
            case 0:
                System.out.println("zero");
                break;
            default:
                System.out.println("default");
                break;
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("twe");
        }
        double d = 10;

        char x = '我';
        //x=x+1;

        short s1 = 1;
        //s1 = s1 + 1;
        System.out.println(s1);

        int m = 1;
        m += 1.1;
        System.out.println(m);

        short s2 = 1;
        s2 += 1;

        List arrayList = new ArrayList();
        arrayList.add("aaa");
        arrayList.add(111);
        System.out.println((Integer) arrayList.get(0));


    }

}
