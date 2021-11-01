package Offer;

public class Offer13二维子矩阵的和 {
    public static void main(String[] args) {

    }
}

/**
 * 方法一：一维前缀和
 */
class NumMatrix_I {
    private int[][] preSum;
    public NumMatrix_I(int[][] matrix) {
        int m = matrix.length;
        if (m>0){
            int n = matrix[0].length;
            preSum = new int[m][n+1];
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    preSum[i][j+1] = preSum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //检索的时间复杂度是O(m)
        int sum = 0;
        for (int i=row1;i<=row2;i++){
            sum += preSum[i][col2+1]-preSum[i][col1];
        }
        return sum;
    }
}

/**
 * 方法二：二维前缀和数组
 */
class NumMatrix_II{

    private int[][] preSum;
    public NumMatrix_II(int[][] matrix){
        int m = matrix.length;
        if (m > 0){
            int n = matrix[0].length;
            preSum = new int[m+1][n+1];
            for (int i = 0;i<m;i++){
                for (int j=0;j<n;j++){
                    preSum[i+1][j+1] = preSum[i][j+1] + preSum[i+1][j] - preSum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
    }
}