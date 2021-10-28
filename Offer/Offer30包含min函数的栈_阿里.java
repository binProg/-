package Offer;
import java.util.LinkedList;
import java.util.Stack;

public class Offer30包含min函数的栈_阿里 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());//-3
        minStack.pop();
        System.out.println(minStack.top());//0
        System.out.println(minStack.min());//-2
    }
}

/**
 * 各个函数的时间复杂度都得是O(1)
 */
class MinStack{

    LinkedList<Integer> stack;
    LinkedList<Integer> minGetter;

    public MinStack(){
        stack = new LinkedList<>();
        minGetter = new LinkedList<>();
    }

    /**
     * 将元素x推入栈中
     * @param x
     */
    public void push(int x){
        stack.addLast(x);
        if (!minGetter.isEmpty()&&minGetter.peek()<x){
            return;
        }
        minGetter.addLast(x);
    }

    /**
     * 删除栈顶的元素
     */
    public void pop(){
        int removeNum = stack.removeLast();
        if (removeNum == minGetter.getLast()){
            minGetter.removeLast();
        }
    }

    /**
     * 获取栈顶的元素
     * @return
     */
    public int top(){
        return stack.getLast();
    }

    /**
     * 检索栈中的最小元素
     * @return
     */
    public int min(){
        return minGetter.getLast();
    }
}