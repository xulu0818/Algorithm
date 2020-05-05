package foundation;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
  public static void main(String[] args){
    int[] input = new int[]{3, 5, 1, 2, 0, 23, 12, 7, 9, 4};
    QuickSort solution = new QuickSort();
    int[] result = solution.quickSort(input);
    System.out.println(Arrays.toString(result));
  }

  /**
   * Clarification: assume input is a int array
   * Method Signature: input --> unsorted array, output --> sorted array
   * Corner Case: array == null || array.length == 0
   * Algorithm: quick sort
   * T: Average(level: logn) --> O(nlogn); Worst --> O(n^2)
   * S: Average(level: n) --> O(logn); Worst --> O(n)
   */
  public int[] quickSort(int[] array){
    if (array == null || array.length == 0){
      return array;
    }
    quickSortHelper(array, 0, array.length - 1);
    return array;

  }
  public void quickSortHelper(int[] array, int left, int right){
    if (left >= right){
      return;
    }
    Random random = new Random();
    int pivot = left + random.nextInt(right - left + 1);
    int pivotValue = array[pivot];
    swap(array, right, pivot);
    int leftBound = left, rightBound = right - 1;
    while (leftBound <= rightBound){
      if (array[leftBound] < pivotValue){
        leftBound++;
      }
      else if (array[rightBound] >= pivotValue){
        rightBound--;
      }
      else {
        swap(array, leftBound++, rightBound--);
      }
    }
    swap(array, leftBound, right);
    //System.out.println(Arrays.toString(array));
    quickSortHelper(array, left, leftBound - 1);
    quickSortHelper(array, leftBound + 1, right);
  }
  public void swap(int[] array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
