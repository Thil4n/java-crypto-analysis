public class MThread extends Thread {

    private int thread_id;

    public MThread(int t) {
        thread_id = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + thread_id + ": " + i / thread_id);
        }
    }
}
