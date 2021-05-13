/**
 * @author surui
 * @date 2021/3/7 10:37 PM
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Scratch scratch = new Scratch();
        scratch.start();
        Thread.sleep(1000);
        scratch.setRunning(false);
    }
}
