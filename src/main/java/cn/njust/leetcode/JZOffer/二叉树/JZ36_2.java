package cn.njust.leetcode.JZOffer.二叉树;

public class JZ36_2 {

    TreeNode head = null;
    TreeNode tmp = null;

    public TreeNode Convert(TreeNode root) {

        // 二叉搜索树与双向链表  中序遍历
        if (root == null) {
            return null;
        }
        Convert(root.left);
        if (head == null) {
            head = root;
            tmp = root;
        } else {
            tmp.right = root;
            root.left = tmp;
            tmp = root;
        }
        Convert(root.right);
        return head;
    }
}
