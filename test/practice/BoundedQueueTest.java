package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BoundedQueueTest {
  private BoundedQueue boundedQueue;
  @Before
  public void setUp() throws Exception {
    //boundedQueue = Mockito.mock(BoundedQueue.class);
    boundedQueue = new BoundedQueue(5);
    boundedQueue.offer(1);
    boundedQueue.offer(2);
    boundedQueue.offer(3);
  }

  @Test
  public void size() {
    assertEquals((long)boundedQueue.size(), 3);
    //System.out.println(boundedQueue.size());
  }

  @Test
  public void isEmpty() {
    assertFalse(boundedQueue.isEmpty());
  }

  @Test
  public void isFull() {
    assertFalse(boundedQueue.isFull());
  }

  @Test
  public void offer() {
    assertTrue(boundedQueue.offer(4));
  }

  @Test
  public void peek() {
    assertEquals((long)boundedQueue.peek(), 1);
  }

  @Test
  public void poll() {
    assertEquals((long)boundedQueue.poll(), 1);
  }
}