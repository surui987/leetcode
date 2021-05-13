import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author surui
 * @date 2021/2/19 8:43 PM
 */
public class Test {
    public static void main(String[] args) throws IOException {


        //String[] 转 Set<String>
        String[] strs = {"a", "b", "c"};
        Set<String> set = new HashSet<>(Arrays.asList(strs));

        System.out.println(set);
        Son son =new Son();
        Son.bTest();

    }
}
