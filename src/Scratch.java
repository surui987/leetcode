/**
 * @author surui
 * @date 2021/3/7 10:13 PM
 */
public class Scratch extends Thread {
    private boolean stop = false;
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public static void main(String[] args) throws InterruptedException {
        Scratch t = new Scratch();
        t.start();
        Thread.sleep(3000);
        t.interrupt();
        Thread.sleep(3000);
        System.out.println("exit");
    }

    @Override
    public void run() {
        System.out.println("begin");
        while (isRunning) {
//            System.out.println("1");
        }
        System.out.println("end");
    }

}
