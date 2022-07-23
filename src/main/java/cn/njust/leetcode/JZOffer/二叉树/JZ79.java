package cn.njust.leetcode.JZOffer.二叉树;

public class JZ79 {

    public boolean IsBalanced_Solution(TreeNode root) {
        // 判断是不是平衡二叉树
        // 如果调用计算树的深度的递归函数  计算得到根节点的深度时，所有节点的深度都已经得到了

        // 在计算深度的函数里加入新功能  计算是否时平衡二叉树 只需要重新定义返回值
        // 返回 depth = -1 表示不是,  返回depth>=0 表示是XXX 并且深度是depth
        return getDepth(root)!=-1;
    }

    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        if(lDepth==-1 || rDepth==-1){
            // 左子树和右子树不是平衡二叉树 那根节点肯定也不是
            return -1;
        }
        // 继续判断根节点是不是平衡二叉树  如果是 返回深度
        return Math.abs(lDepth-rDepth)<=1?Math.max(lDepth,rDepth)+1:-1;
    }


}
