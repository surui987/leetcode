import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author surui
 * @date 2021/2/22 9:56 PM
 */
public class AtomicDemo {
    private static int[] aaa = new int[]{1, 2, 3};
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(aaa);

    public static void main(String[] args) throws NoSuchAlgorithmException {
        int result = atomicIntegerArray.getAndAdd(1, 5);
        System.out.println(atomicIntegerArray.get(1));
        System.out.println(result);
        byte[] bytes = {1, 2, 3};
        byte[] sha = sha(bytes);
        System.out.println(sha);
    }

    public static byte[] sha(byte[] data) throws NoSuchAlgorithmException {
        System.out.println("====");
        return MessageDigest.getInstance("sha-512").digest(data);
    }
}
