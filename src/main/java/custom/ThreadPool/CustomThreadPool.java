package custom.ThreadPool;


/**
 * This creates a thread pool of size n and blockingQueue of length size.
 * It initializes a task executor which dequeues the tasks from the blocking
 * Queue and executes them (calls run method).Once completed waits for new task in 
 * the queue to arrive and then consumes it.
 * @author agarg
 * 
 * Tutorial implemented from 
 * http://www.makeinjava.com/custom-thread-pool-example-without-using-executor-framework/
 *
 */

public class CustomThreadPool {

   int numOfThreads;//defining no of threads
   BlockingQueue<Runnable> bq;
   
   //no of threads and size of blocking queue
   public CustomThreadPool(int n,int size) throws InterruptedException{
     this.numOfThreads = n;
     bq = new BlockingQueue<Runnable>(size);
     for(int i=0;i<n;i++){
       CustomTaskExecutor t = new CustomTaskExecutor(bq);
       Thread t1 = new Thread(t,"thread Number " + i);
       t1.start();
     }
   }
   
   public void submitTask(Runnable r) throws InterruptedException{
     bq.enqueue(r);
   }
}
