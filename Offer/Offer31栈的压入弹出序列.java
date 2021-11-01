package Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序.
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 */
public class Offer31栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,3,5,1,2};
        boolean res = validateStackSequences(pushed, poped);
        System.out.println(res);
    }

    /**
     * 使用一个辅助栈，用来模拟栈的压入和弹出
     * 如果遍历完所有元素后，辅助栈未空，则合法，否则非法
     * @param pushed 栈的压入序列
     * @param poped  栈的弹出序列
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] poped){
        //辅助栈
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (j<poped.length&&!stack.isEmpty()&&stack.peek()==poped[j]){
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
