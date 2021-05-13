import java.util.TreeMap;

/**
 * @author surui
 * @date 2021/2/24 7:53 PM
 */
public class Animal {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("a", null);
        System.out.println(map);

        String property = System.getProperty("java.version");
        System.out.println(property);
        System.setProperty("java.version", "1.7.0_45");
        String property1 = System.getProperty("java.version");
        System.out.println(property1);

        final Animal animal = new Animal();
        ClassLoader classLoader = animal.getClass().getClassLoader();
        System.out.println(classLoader.toString());
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
