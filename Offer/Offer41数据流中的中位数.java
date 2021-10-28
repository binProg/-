package Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer41数据流中的中位数 {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}

/**
 * 数据流中的元素是任意多个的
 *
 *
 */
class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    /**
     * 从数据流中添加一个整数到数据结构中。
     * @param num
     */
    public void addNum(int num) {

        if (maxHeap.size()==minHeap.size()){
            //再加一个元素总共有奇数个元素，加到小顶堆中
            if (maxHeap.size()==0){
                maxHeap.offer(num);
                return; 
            }
            if (num <= minHeap.peek()){
                maxHeap.offer(num);
            }else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        }else{
            //目前有奇数个元素，因新增一个元素到大顶堆中
            if (num>=maxHeap.peek()){
                minHeap.offer(num);
            }else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
        }
    }

    /**
     * 返回目前所有元素的中位数
     * @return
     */
    public double findMedian() {
        return maxHeap.size()==minHeap.size()?(maxHeap.peek()+minHeap.peek())/2.0:maxHeap.peek();
    }
}
