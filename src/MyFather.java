import java.util.*;

/**
 * @author surui
 * @date 2021/4/10 4:55 PM
 */
public class MyFather {
    public static MyFather myFather1;
    public static MyFather myFather2 = new MyFather();

    static {
        System.out.println("静态块");
    }

    {
        System.out.println("构造块");
    }

    public static void main(String[] args) {
        MyFather myFather = new MyFather();
        float f = 10.0f;
        Integer i1 = 128;
        Integer i2 = 128;
        Integer i3 = Integer.valueOf("128");
        Integer i4 = Integer.parseInt("128");
        System.out.println("=====");
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(i3 == i2);
        System.out.println(i4 == i2);
        System.out.println(i3 == 128);
        System.out.println(i4 == 128);
        System.out.println(i3 == i4);


        System.out.println("=====");


        List<String> stringList = new ArrayList<>();
        stringList.add("qq");
        stringList.add(0, "aa");
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));

        System.out.println("=====");

        String[] strs = {"a", "b", "c"};
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        System.out.println(set);


        System.out.println("=========");
        String s = new StringBuilder("aaa").append("bbb").toString();
        String s1 = new StringBuilder("aaa").append("bbb").toString();
        System.out.println(s.intern() == s);
        System.out.println(s1.intern() == s);
        String s2 = new StringBuilder("ja").append("va").toString();
        String s3 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        System.out.println(s3.intern() == s2);

        System.out.println("==========");
        System.out.println(get());
        System.out.println(get("111"));

    }

    public static Integer get() {
        Integer integer;
        try {
            integer = 99;
            return integer;
        } finally {
            integer = 100;
        }
    }
    public static String get(String s) {
        String string;
        try {
            string = "99";
            return string;
        } finally {
            string = "100";
        }
    }
}
