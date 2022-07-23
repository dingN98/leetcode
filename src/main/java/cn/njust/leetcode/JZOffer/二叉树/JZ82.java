package cn.njust.leetcode.JZOffer.二叉树;

public class JZ82 {

    public boolean hasPathSum (TreeNode root, int sum) {
        // 二叉树是否存在路径（根节点到叶子节点）长度等于 sum
        // dfs
        if(root==null){
            return false;
        }
        // root是叶子节点
        if(sum==root.val && root.left==null && root.right==null){
            return true;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3 = new TreeNode(4);
        TreeNode p4 = new TreeNode(5);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p2.left = p4;

        boolean res = new JZ82().hasPathSum(root,9);
        System.out.println(res);
    }
}
