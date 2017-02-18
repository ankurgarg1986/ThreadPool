package custom.ThreadPool;


/**Create a thread pool with Queue size (to hold tasks) of size 3 and thread pool size of 4.
 * Thread Pool
 * This class initializes thread pool and submits task to it .
**/ 
public class ThreadPoolTest {

  public static void main(String[] args) throws InterruptedException {
    CustomThreadPool pool = new CustomThreadPool(3,4);
    for(int i=1;i<10;i++){
      Task t = new Task(i);
      pool.submitTask(t);
     
    }

  }

}
