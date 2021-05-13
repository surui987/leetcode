package test;

/**
 * @author surui
 * @date 2021/2/3 12:41 AM
 */
public class Security {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());
        System.setProperty("java.version","1.7.0_45");
        String s = System.getProperty("java.version");
        System.out.println(s);
    }
}
