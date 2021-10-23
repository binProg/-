package Offer;

import domain.TreeNode;

public class Offer26树的子结构 {
    public static void main(String[] args) {
        int[] vals1 = {4,2,3,4,5,6,7,8,9};
        int[] vals2 = {4,8,9};
        TreeNode A = TreeNode.buildTree(vals1);
        TreeNode B = TreeNode.buildTree(vals2);
        boolean res = isSubStructure(A, B);
        System.out.println(res);
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B){
        if (A==null||B==null){
            return false;
        }
        //判断B是否是A的子树
        return isSub(A,B)||isSubStructure(A.left, B)||isSubStructure(A.right, B);
    }

    public static boolean isSub(TreeNode A, TreeNode B){
        if (B==null){//当B的结点遍历完成
            return true;
        }
        if (A==null){//B的遍历越过了A
            return false;
        }

        return A.val == B.val && isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}
