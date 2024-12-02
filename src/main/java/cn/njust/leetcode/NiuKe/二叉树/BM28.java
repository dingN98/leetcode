package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

public class BM28 {

    int maxDepth = 0;

    // 二叉树的最大深度
    public int maxDepth (TreeNode root) {
        // write code here
        fun(root,0);
        return maxDepth;

    }

    public void fun(TreeNode root,int depth){
        if(root==null){
            return;
        }
        maxDepth = Math.max(maxDepth,depth+1);
        fun(root.left,depth+1);
        fun(root.right,depth+1);
    }

    public static void main(String[] args) {

    }
}
