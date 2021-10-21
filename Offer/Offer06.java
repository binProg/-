package Offer;

import domain.ListNode;

import java.util.Arrays;

public class Offer06 {
    public static void main(String[] args) {
        int[] arr = {1,3,2};
        ListNode head = ListNode.buildList(arr);
        int[] res = reversePrint(head);
        System.out.println(Arrays.toString(res));

    }

    public static int[] reversePrint(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p!=null){
            count++;
            p = p.next;
        }
        p = head;
        int[] res = new int[count];
        for (int i=count-1;i>=0;i--){
            res[i] = p.val;
            p = p.next;
        }
        return res;


    }
}