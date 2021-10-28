package Offer;

public class Offer19正则表达式匹配 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        boolean res = isMatch(s, p);
        System.out.println(res);
    }

    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     *
     * 思路： 动态规划枚举所有匹配的情况
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p){
        //1.dp[i][j]:s的前i个字符和p的前j个字符是否相等
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        //2.base case
        dp[0][0] = true;
        //3.以P的视角来匹配S
        //3.1 P为单个字符，直接比对s[i] == p[j]?
        //3.2 P为“.”, 则不论s[i]是什么字符，s[i]一定等于p[j]
        //3.3 P为“单个字符+*”，则分情况讨论：
        //3.3.1 s[i]=p[j-1]:匹配多个s[i]，相当于每次删除s的i位置元素，则dp[i][j] = dp[i-1][j]
        //3.3.2 s[i]=p[j-1]:但是匹配0个s[i]，相当于p[j-1]和p[j]未出现，则dp[i][j] = dp[i][j-2]
        //3.3.2 s[i]不等于p[j-1]：同3.3.2
        for(int i=0;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];//不匹配
                    if (matches(s,p,i,j-1)){
                        dp[i][j] = dp[i][j] || dp[i-1][j];//匹配0次或多次的情况
                    }
                }else{
                    if (matches(s,p,i,j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean matches(String s, String p, int i, int j){
        if (i == 0){//当s[i]空字符，p不为空字符时，必然不匹配
            return false;
        }
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
