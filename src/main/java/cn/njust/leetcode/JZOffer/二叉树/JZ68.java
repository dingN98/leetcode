package cn.njust.leetcode.JZOffer.二叉树;

public class JZ68 {

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // 二叉搜索树的最近公共祖先
        // 一开始我的想法是   寻找它们俩最短路径的公共部分  但是这样没有用到 二叉搜索树的性质
        // 如果它们俩 一个小于 root 一个大于 root  那么公共祖先必然是 root
        // 如果同时小于root 或者同时大于 root 那么公共祖先 从 root的孩子里找
        if(root==null){
            return -1;
        }
        int rootV = root.val;

        if(p<rootV && q>rootV || p>rootV && q<rootV || p==rootV || q==rootV){
            return rootV;
        }
        if(p<rootV && q<rootV){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p>rootV && q>rootV){
            return lowestCommonAncestor(root.right,p,q);
        }
        return -1;
    }
}
