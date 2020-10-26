package practice;

/**
 * Using an array with fixed length to implement queue
 * methods: size(), isEmpty(), isFull(), offer(), poll(), peek()
 * We use two pointers(head & tail) to denote the top position and bottom position in queue
 */
public class BoundedQueue {
  private int head;
  private int tail;
  private int size;
  private int[] array;

  public BoundedQueue(int capacity) {
    head = 0;
    tail = 0;
    size = 0;
    array = new int[capacity];
  }

  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public boolean isFull(){
    return size == array.length;
  }
  public boolean offer(int element){
    if (size == array.length){
      return false;
    }
    array[tail] = element;
    tail = tail + 1 == array.length ? 0 : tail + 1;
    size++;
    return true;
  }
  public Integer peek(){
    if (size == 0) return null;
    return array[head];
  }
  public Integer poll(){
    if (size == 0) return null;
    Integer result = array[head];
    head = head + 1 == array.length ? 0 : head + 1;
    size--;
    return result;
  }
}
