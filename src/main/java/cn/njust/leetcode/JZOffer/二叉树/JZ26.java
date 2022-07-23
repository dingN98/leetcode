package cn.njust.leetcode.JZOffer.二叉树;

public class JZ26 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        // 树的子结构
        // 我的思路是先在 root1中找到root2
        //      8                          8
        //  9       2                          2
        if(root1==null || root2==null){
            return false;
        }
        return isSame(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean isSame(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        // 都不为null
        return root1.val==root2.val && isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode p1 = new TreeNode(9);
        TreeNode p11 = new TreeNode(2);
        root1.left = p1;
        root1.right = p11;

        TreeNode root2 = new TreeNode(8);
        TreeNode p2 = new TreeNode(8);
        TreeNode p22 = new TreeNode(2);
        root2.left = p2;
        root2.right = p22;

        boolean res = new JZ26().HasSubtree(root1,root2);
        System.out.println(res);

    }
}
