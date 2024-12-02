package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

public class BM32 {

    // BM32 合并二叉树
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1==null && t2==null){
            return null;
        }
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        t1.val += t2.val;

        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;

    }

    public static void main(String[] args) {

    }
}
