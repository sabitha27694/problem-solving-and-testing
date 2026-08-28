import java.util.concurrent.*;

public class AuthStressTest {
    public static void main(String[] args) throws InterruptedException {
        int threads = 50;
        ExecutorService service = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < threads; i++) {
            service.submit(() -> {
                // Simulate login request validation
                boolean success = Math.random() > 0.1; 
                // System.out.println(Thread.currentThread().getName() + " Auth: " + success);
            });
        }
        service.shutdown();
        service.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Stress Test Complete. Handled " + threads + " concurrent requests.");
    }
}