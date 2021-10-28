package Offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40最小的k个数 {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 10;
        int[] res = getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] getLeastNumbers(int[] arr, int k){
        if (k==0||arr.length==0){
            return new int[0];
        }
        //大顶堆
        PriorityQueue<Integer> qu = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i=0;i<k&&i<arr.length;i++){
            qu.offer(arr[i]);
        }
        for (int i=k;i<arr.length;i++){
            if (arr[i]<qu.peek()){
                qu.poll();
                qu.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while (idx<k&&!qu.isEmpty()){
            res[idx++] = qu.poll();
        }
        return res;

    }
}
