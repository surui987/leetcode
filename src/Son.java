import java.lang.reflect.Method;
import java.util.*;

/**
 * @author surui
 * @date 2021/2/22 9:47 PM
 */
public class Son extends Parent {
    static int firstval = 1;

    static {
        System.out.println("son static blocks" + firstval);
        firstval++;
    }

    int secondval = 3;

    static {
        System.out.println("son static blocks" + firstval);
        firstval++;
    }

    public Son() {
        System.out.println("constructor son: firstval=" + firstval + ",second=" + secondval);
        firstval++;
        secondval++;
    }

    {
        System.out.println("son blocks: firstval=" + firstval + ",second=" + secondval);
        firstval++;
        secondval++;
    }

    @Override
    public void bDisplay() {
        System.out.println("son method: firstval=" + firstval + ",second=" + secondval);
        firstval++;
        secondval++;
    }

    //@Override
    public static void aaa() {

    }

    private void fff() {

    }

    public static void bTest() {
        System.out.println("SON static method: firstval=" + firstval);
        firstval++;
    }

    public static void main(String[] args) {
        Class<Son> sonClass = Son.class;
        Method[] declaredMethods = sonClass.getMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + "====");
        }
        Parent parent = new Parent();
        Son son = new Son();
        parent.bTest();
        son.bTest();
        parent.bDisplay();
        //parent.bTest();
        //Parent.bTest();
        int firstval = 10000;
        System.out.println(firstval);
        List<String> objects = Collections.emptyList();
        //objects.add("1");
        System.out.println(objects);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        //ArrayList<String> list2 = (ArrayList<String>) list.subList(0, 0);
        //System.out.println(list2);
        List<String> list1 = list.subList(0, 0);
        System.out.println(list1);

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(map.values());
        arrayList.addAll(Collections.singleton("c"));
        System.out.println(arrayList);

        char alpha = 'A';
        int foo = 64;
        boolean trueExp = true;
        System.out.println(trueExp ? alpha : 0);
        System.out.println(trueExp ? alpha : foo);


        List<Parent> parentList = new ArrayList<>();
        List<Son> sonList = new ArrayList<>();
        parentList.addAll(sonList);

    }
}
