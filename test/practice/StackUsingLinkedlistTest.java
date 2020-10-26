package practice;

import foundation.utilities.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StackUsingLinkedlistTest {
  private StackUsingLinkedlist stackUsingLinkedlist;

  @Before
  public void setUp() throws Exception {
    this.stackUsingLinkedlist = Mockito.mock(StackUsingLinkedlist.class);
    ListNode head = new ListNode(0);
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    head.next = one;
    one.next = two;
  }

  @Test
  public void pop() {
    Mockito.when(stackUsingLinkedlist.pop()).thenReturn(0);
    Assert.assertEquals((long)stackUsingLinkedlist.pop(), 0);
    //stackUsingLinkedlist.push(2);
  }

  @Test
  public void peek() {
    Mockito.when(stackUsingLinkedlist.peek()).thenReturn(1);
    Assert.assertEquals((long)stackUsingLinkedlist.peek(), 1);
  }
}