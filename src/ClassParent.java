/**
 * @author surui
 * @date 2021/2/23 8:02 PM
 */
public class ClassParent {
    private static String str = str();

    static {
        System.out.println("static block");
    }

    public static String str() {
        System.out.println("static method");
        return "str";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("ClassParent", false, ClassLoader.getSystemClassLoader());
    }
}
