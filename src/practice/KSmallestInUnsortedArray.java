package practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {
    public static void main(String[] args){
        KSmallestInUnsortedArray kSmallestInUnsortedArray = new KSmallestInUnsortedArray();
        int[] kSmallestArray = kSmallestInUnsortedArray.kSmallest(new int[]{3,1,5,2,4}, 1);
    }
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0){
            return new int[k];
        }
        int[] result = new int[k];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        maxHeap.offer(array[0]);
        for (int i = 0; i < array.length; i++){
            if (i < k){
                maxHeap.offer(array[i]);
                continue;
            }
            int temp = maxHeap.peek();
            if (temp > array[i]){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
            System.out.println(result.toString());
        }
        for (int i = k - 1; i >= 0; i--){
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
