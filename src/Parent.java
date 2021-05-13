/**
 * @author surui
 * @date 2021/2/22 9:36 PM
 */
public class Parent {
    static int firstval = 1;

    static {
        System.out.println("parent static blocks" + firstval);
        firstval++;
    }

    int secondval = 3;

    static {
        System.out.println("parent static blocks" + firstval);
        firstval++;
    }

    public Parent() {
        System.out.println("constructor parent: firstval=" + firstval + ",second=" + secondval);
        firstval++;
        secondval++;
    }

    {
        System.out.println("parent blocks: firstval=" + firstval + ",second=" + secondval);
        firstval++;
        secondval++;
    }

    public void bDisplay() {
        System.out.println("parent method: firstval=" + firstval + ",second=" + secondval);
        firstval++;
        secondval++;
    }

    public static void bTest() {
        System.out.println("parent static method: firstval=" + firstval);
        firstval++;
    }

    public final void cTest() {
        System.out.println("parent static method: firstval=" + firstval);
        firstval++;
    }

    private void dTest() {
        System.out.println("parent static method: firstval=" + firstval);
        firstval++;
    }

    private void eee() {

    }
}
