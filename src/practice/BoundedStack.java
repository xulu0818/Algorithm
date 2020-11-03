package practice;

/**
 * what we need:
 * 1. an array to store elements
 * 2. a head pointer to push() element and pop() element
 */
public class BoundedStack {
  private int head;
  private int[] array;

  public BoundedStack(int cap){
    head = -1;
    array = new int[cap];
  }
  public boolean push(int element){
    if (head == array.length - 1){
      return false;
    }
    array[++head] = element;
    return true;
  }
  public Integer pop(){
    return head == -1 ? null : array[head--];
  }
  public Integer top(){
    return head == -1 ? null : array[head];
  }
}
