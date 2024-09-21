import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static void main(String[] args) {

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(()->{
                SimulatedJob jobA = new SimulatedJob();
                jobA.work("Job_A");
            });
            executor.submit(()->{
                SimulatedJob jobA = new SimulatedJob();
                jobA.work("Job_B");
            });
            executor.shutdown();
        }
    }
}
