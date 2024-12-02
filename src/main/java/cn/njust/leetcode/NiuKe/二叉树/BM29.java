package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

public class BM29 {

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root==null){
            return false;
        }
        sum -= root.val;
        if(sum==0 && root.left==null && root.right==null){
            return true;
        }
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);

    }
}
