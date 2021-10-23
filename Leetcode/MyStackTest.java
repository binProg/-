package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        for (int i = 0; i < 3; i++) {
            obj.push(i);
        }
        obj.push(3);
    }
}

class MyStack{

    Queue<Integer> qu1, qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        qu2.offer(x);
        while (!qu1.isEmpty()){
            qu2.offer(qu1.poll());
        }
        Queue<Integer> tmp = qu1;
        qu1 = qu2;
        qu2 = qu1;
    }

    public int pop() {
        return qu2.isEmpty()?-1:qu2.poll();
    }

    public int top() {
        return qu1.isEmpty()?-1:qu1.peek();
    }

    public boolean empty() {
        return qu1.isEmpty();
    }
}
