import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicePractise {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            System.out.println("The file is being uploaded by " + Thread.currentThread().getName());
        };

        for(int i =0; i < 5 ; i ++){
            service.submit(task);
        }

        service.shutdown();


        ExecutorService executorService = Executors.newSingleThreadExecutor();


        Callable<Integer> tasks = () ->  1+3;

        Future<Integer> res = executorService.submit(tasks);   
        
        try {
            System.out.println(res.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        executorService.shutdown();
    }

}
