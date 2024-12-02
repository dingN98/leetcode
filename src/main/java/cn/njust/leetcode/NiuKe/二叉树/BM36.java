package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

public class BM36 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);



    }

    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
