



public class Singleton {

    private static volatile Singleton instance;
    private  Singleton(){}; //private constructor

    public static Singleton getInstance(){
        if(instance == null){ //multiple threads can access getInstance method
            synchronized(Singleton.class){
                if(instance == null){ // but this check ensures only one thread can access
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}




