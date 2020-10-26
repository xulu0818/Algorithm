package practice;

import foundation.utilities.ListNode;

public class QueueUsingLinkedList {
  private ListNode head;
  private ListNode tail;
  public void offer(int value){
    if (head == null){
      head = new ListNode(value);
      tail = head;
    }
    else{
      tail.next = new ListNode(value);
      tail = tail.next;
    }
  }
  public Integer peek(){
    if (head == null){
      return null;
    }
    return head.val;
  }
  public Integer poll(){
    if (head == null){
      return null;
    }
    ListNode newHead = head;
    head = head.next;
    if (head == null){
      tail = null;
    }
    newHead.next = null;
    return newHead.val;
  }
}
