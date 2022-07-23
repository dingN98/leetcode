package cn.njust.leetcode.JZOffer.二叉树;

public class JZ55_2 {


    public int TreeDepth(TreeNode root) {
        // 二叉树的深度  等于 max(左子树深度，右子树深度)+1
        if(root==null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }

}
