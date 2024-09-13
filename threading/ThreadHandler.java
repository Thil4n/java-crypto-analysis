public class ThreadHandler {
    public static void main(String[] args) {

        MThread2 m = new MThread2(0);

        Thread t = new Thread(m);
        t.start();

        MThread2 m1 = new MThread2(1);

        Thread t1 = new Thread(m1);
        t1.start();

    }
}
