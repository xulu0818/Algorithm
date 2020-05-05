package foundation;

public class Linkedlist {
  public static void main(String[] args){

  }
  public ListNode reverseLinkedList(ListNode head){
    if (head == null || head.next == null){
      return head;
    }
    ListNode prev = null;
    ListNode cur = head;
    while(cur != null){
      ListNode next = head.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
  //T: O(n); S: O(n)
  public ListNode reverseLinkedListRecur(ListNode head){
    if (head == null || head.next == null){
      return head;
    }
    ListNode newHead = reverseLinkedListRecur(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
