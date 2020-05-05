package foundation;

public class BinarySearch {
  public static void main(String[] args) {
    //						0, 1, 2, 3, 4, 5, 6  7, 8
    int[] array = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 15};
    BinarySearch test = new BinarySearch();
    int result = test.binarySearch(array, 11);
    System.out.println(result);
  }

  public int binarySearch(int[] array, int target) {
    //corner case
    if (array == null || array.length == 0) {
      return -1;
    }
    int start = 0, end = array.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    if (array[start] == target) {
      return start;
    } else if (array[end] == target) {
      return end;
    }
    return -1;
  }
}
