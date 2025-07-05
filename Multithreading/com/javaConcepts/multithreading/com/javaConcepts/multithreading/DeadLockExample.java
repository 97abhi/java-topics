public class DeadLockExample {

    static final Object resource1 = "A";
    static final Object resource2 = "B";
    public static void main(String[] args) {

    Thread t1 = new Thread(() -> {

        synchronized(resource1){
            System.out.println("Thread 1 has locked " + resource1);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

            synchronized(resource2){
                System.out.println("Thread 2 has loacked " + resource2);
            }
        };
    });


    Thread t2 = new Thread(() -> {

        synchronized(resource2){
            System.out.println("Thread 1 has locked " + resource2);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

            synchronized(resource1){
                System.out.println("Thread 2 has loacked " + resource1);
            }
        };
    });

    t1.start();
    t2.start();
        
    }    

}
