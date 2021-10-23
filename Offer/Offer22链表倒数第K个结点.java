package Offer;

import domain.ListNode;

public class Offer22链表倒数第K个结点 {
    public static void main(String[] args) {
        int[] vals = {1,2,3,4,7};
        int k = 6;
        ListNode head = ListNode.buildList(vals);
        ListNode target = getKthFromEnd(head, k);
        System.out.println(target.val);
    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k){
        ListNode slow = head;
        ListNode fast = head;
        while (k>0 && fast!=null){
            fast = fast.next;
            k--;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
