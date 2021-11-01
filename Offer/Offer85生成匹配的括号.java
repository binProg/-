package Offer;
import java.util.LinkedList;
import java.util.List;

/**
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Offer85生成匹配的括号 {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }

    private static List<String> res;
    private static StringBuilder builder;

    /**
     * 回溯 + 剪枝
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        builder = new StringBuilder();
        dfs(n, 0, 0);
        return res;
    }

    /**
     *
     * @param n
     * @param left：当前路径中左括号的数量
     * @param right：当前路径中右括号的数量
     */
    public static void dfs(int n, int left, int right){
        //剪枝
        if (left>n || right>n || right>left){
            return;
        }
        //记录结果
        if (left == n && right == n){
            res.add(builder.toString());
            return;
        }

        //做选择
        builder.append("(");
        dfs(n, left+1, right);
        builder.deleteCharAt(builder.length()-1);

        builder.append(")");
        dfs(n, left, right+1);
        builder.deleteCharAt(builder.length()-1);
    }
}