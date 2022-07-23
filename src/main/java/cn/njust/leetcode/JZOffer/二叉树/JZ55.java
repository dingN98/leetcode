package cn.njust.leetcode.JZOffer.二叉树;

public class JZ55 {

    int depthMax = 0;

    public int TreeDepth(TreeNode root) {
        // 二叉树的深度
        search(root,0);
        return depthMax;


    }

    public void search(TreeNode root,int depth){
        if(root==null){
            depthMax = Math.max(depthMax,depth);
            return;
        }
        search(root.left,depth+1);
        search(root.right,depth+1);
    }

}
