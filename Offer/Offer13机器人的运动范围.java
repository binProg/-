package Offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子
 */
public class Offer13机器人的运动范围 {
    public static void main(String[] args) {
        int m = 2, n =3, k = 1;
        int res = movingCount(m, n ,k);
        System.out.println(res  );
    }

    private static int count = 0;
    private static boolean[][] visited;
    public static int movingCount(int m, int n, int k){
        visited = new boolean[m][n];
        dfs(m, n, 0, 0, k);
        return count;
    }

    public static void dfs(int m, int n, int i, int j, int k){
        //剪枝
        //越界或者当前位置已经访问过
        if (i<0||j<0||i>=m||j>=n||visited[i][j]){
            return;
        }
        //当前行列各位数字之和是否大于K
        if (isBiggerK(i, j, k)){
            return;
        }
        count++;
        //做选择
        visited[i][j] = true;
        dfs(m, n, i+1, j, k);
        dfs(m, n, i-1, j, k);
        dfs(m, n, i, j+1, k);
        dfs(m, n, i, j-1, k);
    }

    public static boolean isBiggerK(int i, int j, int k){
        int sum = 0;
        while (i!=0){
            sum += i%10;
            i/=10;
        }
        while (j!=0){
            sum += j%10;
            j/=10;
        }
        return sum>k;
    }
}
