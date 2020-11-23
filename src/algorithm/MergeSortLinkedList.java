package algorithm;

import foundation.utilities.ListNode;

public class MergeSortLinkedList {
  public static void main(String[] args){
    //create a linkedlist with nodes: 1 -> 3 -> 5 -> 2 -> 4 -> 6 -> null
    ListNode myList = new ListNode(1);
    ListNode head = myList;
    head.next = new ListNode(3);
    head = head.next;
    head.next = new ListNode(5);
    head = head.next;
    head.next = new ListNode(2);
    head = head.next;
    head.next = new ListNode(4);
    head = head.next;
    head.next = new ListNode(6);
    head = myList;
    while (head != null){
      System.out.print(head.val + " -> ");
      head = head.next;
    }
    System.out.println(" ");
    ListNode newHead = new MergeSortLinkedList().mergeSort(myList);
    while (newHead != null){
      System.out.print(newHead.val + " -> ");
      newHead = newHead.next;
    }
  }
  public ListNode mergeSort(ListNode head) {
    // Write your solution here
    //1. find the middle node of the linkedlist; 2. sort and merge the 2 parts of the linkedlist
    if (head == null || head.next == null){
      return head;
    }
    ListNode middle = findMiddle(head);
    ListNode middleNode = middle.next;
    middle.next = null;
    ListNode leftSorted = mergeSort(head);
    ListNode rightSorted = mergeSort(middleNode);
    ListNode newHead = merge(leftSorted, rightSorted);
    return newHead;
  }
  private ListNode merge(ListNode leftHead, ListNode rightHead){
    ListNode dummy = new ListNode(0);
    ListNode newHead = dummy;
    while (leftHead != null && rightHead != null){
      if (leftHead.val < rightHead.val){
        newHead.next = leftHead;
        leftHead = leftHead.next;
      }
      else {
        newHead.next = rightHead;
        rightHead = rightHead.next;
      }
      newHead = newHead.next;
    }
    if (leftHead != null){
      newHead.next = leftHead;
    }
    if (rightHead != null){
      newHead.next = rightHead;
    }
    return dummy.next;
  }
  public ListNode findMiddle(ListNode head){
    if (head == null){
      return head;
    }
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
