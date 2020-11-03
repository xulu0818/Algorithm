package practice;

import foundation.utilities.ListNode;

/**
 * listNode: 1 --> 2 --> 3
 * push 0: 0 --> 1 --> 2 --> 3
 * pop: 1 --> 2 --> 3
 * pop: 2 --> 3
 * peek: 1
 */
public class StackUsingLinkedlist {
  private ListNode head;
  public Integer pop(){
    if (head == null){
      return null;
    }
    ListNode prev = head;
    head = head.next;
    prev.next = null;
    return prev.val;
  }
  public void push(int value){
    ListNode newHead = new ListNode(value);
    newHead.next = head;
    head = newHead;
  }
  public Integer peek(){
    if (head == null){
      return null;
    }
    return head.val;
  }
}
