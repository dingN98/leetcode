package cn.njust.leetcode.JZOffer.二叉树;

public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    // 父亲节点
    TreeLinkNode next = null;
    public TreeLinkNode(int val){
        this.val = val;
    }
}
