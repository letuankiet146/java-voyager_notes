public class SimulatedJob {
    public void work(String title) {
        System.out.printf("Start %s \n", title);
        for (int i = 0; i < 10 ; i++){
            System.out.printf("%s step %d \n", title, i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.printf("Error while processing %s%n", title);
            }
        }

        System.out.printf("Finish %s \n", title);
    }
}
