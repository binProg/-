package Offer;

public class Offer04 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        int target = 5;
        boolean res = findNumberIn2DArray(matrix, target);
        System.out.println(res);
    }

    /**
     * 二维数组中的target查找:
     * 线性查找，从矩阵的右上角开始查找，时间复杂O(n+m)
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m-1;//从矩阵的右上角出发
        while (i>=0&&i<n&&j>=0&&j<m){
            if (target == matrix[i][j]){
                return true;
            }else if (target > matrix[i][j]){//target更大，就向下查找
                i++;
            }else if (target < matrix[i][j]){//target更小，就向左查找
                j--;
            }
        }
        return false;
    }
}