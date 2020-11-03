package practice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapImplementationTest {
  private HashMapImplementation hashMapImplementation;
  @Before
  public void setUp() throws Exception {
    hashMapImplementation = new HashMapImplementation(10, 0.75f);
    hashMapImplementation.put("Penny", 27);
    hashMapImplementation.put("Jane", 26);
    hashMapImplementation.put("Sue", 26);
    hashMapImplementation.put("Amy", 24);
    hashMapImplementation.put("Cody", 30);
  }

  @Test
  public void size() {
    assertEquals(hashMapImplementation.size(), 5);
  }

  @Test
  public void isEmpty() {
    assertFalse(hashMapImplementation.isEmpty());
  }

  @Test
  public void containsKey() {
    assertTrue(hashMapImplementation.containsKey("Jane"));
  }

  @Test
  public void containsValue() {
    assertTrue(hashMapImplementation.containsValue(26));
  }

  @Test
  public void get() {
    assertEquals(hashMapImplementation.get("Penny"), null);
    assertEquals(hashMapImplementation.get("Sue"), 26);
    assertEquals(hashMapImplementation.get("Cody"), 30);
    assertEquals(hashMapImplementation.get("Tyler"), null);
  }

  @Test
  public void put() {
    assertEquals(hashMapImplementation.put("Cody", 30), 30);
    assertEquals(hashMapImplementation.put("Enzo", 31), null);
  }

  @Test
  public void remove() {
    assertEquals(hashMapImplementation.remove("Bryan"), null);
    assertEquals(hashMapImplementation.remove("Cody"), 30);
  }
}