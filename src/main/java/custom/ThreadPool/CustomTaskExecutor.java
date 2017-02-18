package custom.ThreadPool;

public class CustomTaskExecutor implements Runnable {

  BlockingQueue<Runnable> bq;

  public CustomTaskExecutor(BlockingQueue<Runnable> bq) {
    this.bq = bq;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Runnable r = bq.dequeue();
        String name = Thread.currentThread().getName();
        System.out.println("Task started by thread " + name);
        r.run();
        System.out.println("Task ended by thread " + name);
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
