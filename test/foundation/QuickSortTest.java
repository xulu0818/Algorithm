package foundation;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class QuickSortTest {
  private QuickSort solution;

  @Before
  public void setUp(){
    this.solution = Mockito.mock(QuickSort.class);
  }

  @Test
public void testQuickSort() {
    Mockito.when(solution.quickSort(new int[]{1,4,3,2,5})).thenReturn(new int[]{1,2,3,4,5});
    Mockito.when(solution.quickSort(null)).thenReturn(null);
  }
}