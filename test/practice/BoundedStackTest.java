package practice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoundedStackTest {
  private BoundedStack boundedStack;
  @Before
  public void setUp() throws Exception {
    boundedStack = new BoundedStack(5);
    boundedStack.push(1);
    boundedStack.push(2);
    boundedStack.push(3);
  }

  @Test
  public void push() {
    assertTrue(boundedStack.push(4));
  }

  @Test
  public void pop() {
    assertEquals((long)boundedStack.pop(), 3);
  }

  @Test
  public void top() {
    assertEquals((long)boundedStack.top(), 3);
  }
}