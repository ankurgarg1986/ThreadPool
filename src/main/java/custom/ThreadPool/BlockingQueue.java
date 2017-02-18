package custom.ThreadPool;

import java.util.LinkedList;


public class BlockingQueue<T> {

    int maxSize;
    LinkedList<T> ll;
    
    public BlockingQueue(int size){
      this.maxSize = size;
      ll = new LinkedList<T>();
    }
    
    public synchronized void enqueue(T t) throws InterruptedException{
      if(ll.size() == this.maxSize){
        wait();
      }
      ll.offer(t);
      notifyAll();
    }
    
    
    public synchronized T dequeue() throws InterruptedException{
      if(ll.size() == 0){
        wait();
      }
      T t1 = ll.poll();
      notifyAll();
      return t1;
    }
}
