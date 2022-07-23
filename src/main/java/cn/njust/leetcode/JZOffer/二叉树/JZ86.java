package cn.njust.leetcode.JZOffer.二叉树;

public class JZ86 {

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // 还是俩节点的公共祖先  但这个二叉树是普通的二叉树  上一个是二叉查找树
        // 公共祖先一共就三种情况  
        // (1)都在左子树，先找到谁，谁就是公共祖先
        // (2)都在右子树，先找到谁，谁就是公共祖先
        // (3)在两边，返回  root
        // 递归 只遍历一次
        if(root==null){
            // 不在左子树 或者 不在右子树
            return -1;
        }
        if(root.val==o1 || root.val==o2){
            return root.val;
        }
        
        int isInLeft = lowestCommonAncestor(root.left,o1,o2);
        int isInRight = lowestCommonAncestor(root.right,o1,o2);
        if(isInLeft==-1){
            // 都不在左子树（都在右子树）
            return isInRight;
        }
        if(isInRight==-1){
            // 都不在右子树（都在左子树）
            return isInLeft;
        }
        // 一个在左  一个在右
        return root.val;
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
        int res = new JZ86().lowestCommonAncestor(root,2,3);
        System.out.println(res);
    }
}
