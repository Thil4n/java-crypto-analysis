public class MThread2 implements Runnable {

    private int thread_id;

    public MThread2(int t) {
        thread_id = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + thread_id + ": " + i / thread_id);
        }
    }
}
