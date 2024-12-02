package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

public class BM37_2 {

    // BM37 二叉搜索树的最近公共祖先
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        int val = root.val;

        if(p<val && q<val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p>val && q>val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return val;

    }
}
