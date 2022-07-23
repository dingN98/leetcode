package cn.njust.leetcode.JZOffer.二叉树;

public class JZ36 {

    TreeNode head = null;
    TreeNode tmp = null;

    public TreeNode Convert(TreeNode pRootOfTree) {

        // 二叉搜索树与双向链表  中序遍历
        search(pRootOfTree);
        return head;
    }

    public void search(TreeNode root){
        if(root==null){
            return;
        }
        search(root.left);
        if(head==null){
            head = root;
            tmp = root;
        }else{
            tmp.right = root;
            root.left = tmp;
            tmp = tmp.right;
        }
        search(root.right);
    }
}
