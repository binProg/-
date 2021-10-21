package Offer;

import domain.TreeNode;

public class Offer07 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode.postOrder(root);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder.length==0||inorder.length==0){
            return null;
        }
        return buildTree(preorder,0,preorder.length-1,
                inorder, 0, inorder.length-1);
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd){
        //1.根据根节点的值创建根节点
        // 前序遍历的第一个值就是根节点的值
        int rootVal = preorder[preStart];
        //创建根结点
        TreeNode root = new TreeNode(rootVal);
        if (preStart==preEnd||inStart==inEnd){
            return root;
        }
        //2.确定中序遍历中根节点的位置
        int rootIdx = inStart;
        while (rootIdx<=inEnd && inorder[rootIdx]!=rootVal){
            ++rootIdx;
        }
        if (rootIdx>inEnd){
            return null;
        }
        //3.根据中序遍历，确认左子树的结点个数和结束位置（前序遍历）
        int leftLen = rootIdx - inStart;
        int leftEnd = preStart+leftLen;
        //若左子树结点个数大于0，则构建左子树
        if (leftLen > 0){
            root.left = buildTree(preorder, preStart+1, leftEnd, inorder, inStart, rootIdx-1);
        }
        //若右子树个数大于0，则构建右子树
        if (leftLen < preEnd-preStart){
            root.right = buildTree(preorder, leftEnd+1, preEnd, inorder, rootIdx+1, inEnd);
        }
        return root;

    }
}
