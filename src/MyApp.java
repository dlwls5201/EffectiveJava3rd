import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyApp {

    private static volatile boolean stopRequest;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequest) {
                i++;
                System.out.println("i : " + i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequest = true;

        ExecutorService execService1 = Executors.newFixedThreadPool(2);
        ExecutorService execService2 = Executors.newCachedThreadPool();
        ExecutorService execService3 = Executors.newSingleThreadExecutor();
    }
}
