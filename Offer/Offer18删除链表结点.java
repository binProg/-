package Offer;

import domain.ListNode;

/**
 * 在O(1)时间复杂度内，删除值为val的结点
 */
public class Offer18删除链表结点 {
    public static void main(String[] args) {
        int[] vals = {4,5,1,9};
        ListNode head = ListNode.buildList(vals);
        int val = 5;
        head = deleteNode(head, val);
        ListNode p = head;
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }

    }

    public static ListNode deleteNode(ListNode head, int val){
        ListNode toBeDel = head;
        //找到待删除的结点
        while (toBeDel!=null && toBeDel.val!=val){
            toBeDel = toBeDel.next;
        }
        if (toBeDel == null){//没有待删除的结点
            return head;
        }
        //存在待删除结点，分情况对结点进行处理
        if (toBeDel == head){
            //待删除结点是头结点
            return head.next;
        }else if (toBeDel.next == null){
            //待删除结点是尾结点
            ListNode p = head;
            while (p.next!=toBeDel){
                p = p.next;
            }
            p.next = null;
        }else{
            //待删除结点是中间结点
            toBeDel.val = toBeDel.next.val;
            toBeDel.next = toBeDel.next.next;
        }
        return head;
    }
}
