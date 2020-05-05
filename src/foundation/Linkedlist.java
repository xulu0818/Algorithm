package foundation;

import foundation.utilities.ListNode;

public class Linkedlist {
  public static void main(String[] args){
    Linkedlist linkedlist = new Linkedlist();
    //create linked list: 2 --> 1 --> 3 --> 5 --> null
    ListNode a1 = new ListNode(2);
    ListNode a2 = new ListNode(1);
    ListNode a3 = new ListNode(3);
    ListNode a4 = new ListNode(5);
    a1.next = a2;
    a2.next = a3;
    a3.next = a4;
    a4.next = null;
    ListNode reverseResult = linkedlist.reverseLinkedList(a1);
    //System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
    linkedlist.printHelper(reverseResult);
    ListNode reverseRecurResult = linkedlist.reverseLinkedListRecur(reverseResult);
    linkedlist.printHelper(reverseRecurResult);
  }

  //T: O(n); S: O(1)
  public ListNode reverseLinkedList(ListNode head){
    if (head == null || head.next == null){
      return head;
    }
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null){
      ListNode next = cur.next;
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
  public void printHelper(ListNode head){
    while (head != null){
      System.out.print(head.val + " --> ");
      head = head.next;
    }
    System.out.println("null");
  }
}
