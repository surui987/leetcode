package thread;

/**
 * @author surui
 * @date 2021/3/8 8:53 PM
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Thread td = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100000L);
                } catch (InterruptedException e) {
                    System.out.println("线程是否处于中断状态" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                    System.out.println("abc");
                }
                System.out.println("def");
            }
        });
        td.start();
        td.interrupt();
    }
}
