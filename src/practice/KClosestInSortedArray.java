package practice;

import java.util.Arrays;

public class KClosestInSortedArray {
  /**
   * Given a target integer T, a non-negative integer K and an integer array A sorted in
   * ascending order, find the K closest numbers to T in A.
   *
   * T: O(logn + k)
   * S: O(1)
   */
  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 3, 4, 5, 7, 8, 9, 12};
    int target = 2;
    int k = 5;
    KClosestInSortedArray kclosest = new KClosestInSortedArray();
    int[] result = kclosest.findKClosestInSortedArray(input, k, target);
    System.out.println(Arrays.toString(result));
  }

  public int[] findKClosestInSortedArray(int[] array, int k, int target) {
    //corner cases: null, empty, k == 0 || k < input.length
    if (array == null || array.length == 0) {
      return array;
    }
    if (k == 0) {
      return new int[0];
    }
    if (k > array.length) {
        return array;
    }

    //add K Closest numbers in a new array
    int[] result = new int[k];
    int left =  binarySearch(array, target);;
    int right = left + 1;
    for (int i = 0; i < k; i++){
      if (right > array.length - 1 || left >= 0 && target - array[left] < array[right] - target){
        result[i] = array[left--];
      }
      else{
        result[i] = array[right++];
      }
    }
    return result;

  }

  public int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (array[right] < target) {
      return right;
    }
    return left;
  }
}
