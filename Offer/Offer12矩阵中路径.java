package Offer;

public class Offer12矩阵中路径 {
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
     * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'}, {'S','F','C','S'}, {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean res = exist(board, word);
        System.out.println(res);
    }

    /**
     * 从矩阵的每个位置开启一次dfs，只要找到一个满足word的字符串，返回结果
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS + 剪枝
     * @param board:矩阵
     * @param word：目标字符串
     * @param i：矩阵行索引
     * @param j：矩阵列索引
     * @param k：字符串索引
     * @return
     */
    public static boolean dfs(char[][] board, String word, int i, int j, int k){
        //结束条件
        if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(k)){
            return false;
        }
        if (k == word.length()-1){
            //已经匹配完成word
            return true;
        }
        //修改当前符合条件的矩阵值，以说明其已被访问
        board[i][j] = ' ';
        //遍历其它方向
        if (dfs(board, word, i+1, j, k+1)||dfs(board, word, i-1, j, k+1)
        ||dfs(board, word, i, j+1, k+1)||dfs(board, word, i, j-1, k+1)){
            return true;
        }
        board[i][j] = word.charAt(k);
        return false;
    }

}
