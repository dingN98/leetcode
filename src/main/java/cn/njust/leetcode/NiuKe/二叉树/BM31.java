package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

public class BM31 {

    boolean isSymmetrical(TreeNode pRoot) {

        if(pRoot==null){
            return true;
        }

        return fun(pRoot.left,pRoot.right);
    }

    public boolean fun(TreeNode p1,TreeNode p2){
        if(p1==null && p2==null){
            return true;
        }
        if(p1!=null && p2!=null){
            return p1.val==p2.val && fun(p1.left,p2.right) && fun(p1.right,p2.left);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
