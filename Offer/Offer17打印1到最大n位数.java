package Offer;

public class Offer17打印1到最大n位数 {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
     * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * @param args
     */
    public static void main(String[] args) {
        int n = 1;
        String res = printNums(n);
        System.out.println(res);
    }

    private static StringBuilder res;
    private static char[] loop, num;
    /**
     * n无限制，所以考虑到大数问题。
     * 大数问题：用字符串表示short/int/long
     * 本质：全排列dfs解决
     * @param n
     * @return
     */
    public static String printNums(int n){
        res = new StringBuilder();
        loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        num = new char[n];
        dfs(0, n);
        res.deleteCharAt(res.length()-1);
        return res.toString().substring(2);
    }

    /**
     * @param x: 表示数位
     */
    public static void dfs(int x, int n){
        if (x == n){//终止条件，已经遍历完所有位的数
           res.append(String.valueOf(num)+",");
           return;
        }
        //做选择
        for (char i: loop){
            num[x] = i;
            //继续遍历第x+1位
            dfs(x+1, n);
        }
    }
}
