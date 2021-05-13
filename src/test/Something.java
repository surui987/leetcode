package test;

/**
 * @author surui
 * @date 2021/2/3 12:33 AM
 */
public class Something {
    public static void main(String[] args) {
        final Other o = new Other();
        new Something().add(o);
    }

    public void add(Other o) {
        o.increase();
        o = new Other();
    }
}
