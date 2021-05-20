public class OneTwoThread {
    static Thread a = new Thread(() -> {
        while (true) {
            synchronized (OneTwoThread.class){
                OneTwoThread.class.notify();
                System.out.print(1);
                try {
                    OneTwoThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    static Thread b = new Thread(() -> {
        while (true) {
            synchronized (OneTwoThread.class) {
                OneTwoThread.class.notify();
                System.out.print(2);
                try {
                    OneTwoThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    public static void main(String[] args) throws InterruptedException {

        a.start();
        Thread.sleep(100);
        b.start();
    }
}
