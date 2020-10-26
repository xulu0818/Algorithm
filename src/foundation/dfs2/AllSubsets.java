package foundation.dfs2;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
  private List<Integer> dividedList1;
  private List<Integer> dividedList2;
  private int totalSum = 0;
  private int tempSum = 0;
  private int globalMin = Integer.MAX_VALUE;
  public static void main(String[] args){
    AllSubsets divideArrayMinimalDiff = new AllSubsets();
    divideArrayMinimalDiff.divideArray();


  }

  //1.2 divide array into 2 parts which has the minimum sum difference
  public void divideArray(){
    int[] input = new int[]{1, 10, 3, 8, 2, 7, 3, 6};
    for(int i = 0; i < input.length; i++){
      totalSum = totalSum + input[i];
    }
    List<Integer> tempList = new ArrayList<>();
    divideArrayHelper(input, 0, tempList);
    System.out.println(dividedList1);
  }

  public void divideArrayHelper(int[] input, int index, List<Integer> tempList){
    if (index == input.length){
//      int tempSum = 0;
//      for (int i = 0; i < tempList.size(); i++){
//        tempSum = tempSum + tempList.get(i);
//      }
      int diff = Math.abs((totalSum - tempSum) - tempSum);
      if (diff < globalMin){
        globalMin = diff;
        dividedList1 = new ArrayList<>(tempList);
      }
      return;
    }
    //input[index] contains in tempList
    tempList.add(input[index]);
    tempSum = tempSum + input[index];
    divideArrayHelper(input, index + 1, tempList);
    tempList.remove(tempList.size() - 1);
    tempSum = tempSum - input[index];

    //input[index] does not contains in tempList
    divideArrayHelper(input, index + 1, tempList);
  }

}
