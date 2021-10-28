package Offer;

public class Offer32复杂链表的复制_快手 {

    public static Node copyRandomList(Node head) {
        //1.复制链表
        copyNode(head);
        //2.获取randomAccess
        randomAccessNode(head);
        //3.切分链表
        return splitList(head);
    }

    public static void copyNode(Node head){
        Node p = head;
        while (p!=null){
            Node q = new Node(p.val);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
    }

    public static void randomAccessNode(Node head){
        Node p = head;
        while (p!=null){
            Node q = p.next;
            q.random = p.random==null?null:p.random.next;
            p = q.next;
        }
    }

    public static Node splitList(Node head){
        Node p = head;
        Node dummy = new Node(0);
        Node q = dummy;
        while (p!=null){
            q.next = p.next;
            q = q.next;
            p.next = q.next;
            p = p.next;
        }
        return dummy.next;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}