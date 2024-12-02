package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

public class BM28_2 {


    // 二叉树的最大深度
    public int maxDepth (TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

    }


    public static void main(String[] args) {

    }
}
