package custom.ThreadPool;
public class Task implements Runnable {

  int num;
  
  public Task(int n){
    this.num = n;
  }
  @Override
  public void run() {

    try {
      System.out.println("Start executing of task number :"+ num);
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("End executing of task number :"+ num);
  }

}
