package thread;

/**
 * @author surui
 * @date 2021/3/8 8:54 PM
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程是否处于中断状态" + Thread.currentThread().isInterrupted());
            }
        });
        td.start();
        td.interrupt();

        String s = String.valueOf(3);
        String string = Integer.toString(2);
        String argqs[] = {"1", "1", "2"};
    }


}
