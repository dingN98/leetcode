package cn.njust.leetcode.JZOffer.二叉树;

public class JZ8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        // 二叉树的下一个节点（中序遍历）
        // 我一开始只考虑了一种情况 ，就是题解的第一中情况
        // 设当前节点是A
        // 1、节点A有右孩子，那么就是从右孩子出发，不断寻找左孩子
        // 2、节点A是左孩子，直接返回 父亲节点
        // 3、节点A是右孩子，返回父亲节点，如果变成了左孩子，就是情况2，如果还是右孩子，一直返回父亲节点


        if(pNode==null){
            return null;
        }
        // 情况1
        if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }
        // 情况2  前提 没有右孩子
        // 有父亲节点
        while(pNode.next!=null){
            // 情况2 是左孩子
            if(pNode.next.left==pNode){
                return pNode.next;
            }
            // 情况3 是右孩子
            pNode = pNode.next;
        }
        // 回到根节点 同时没有右孩子
        return null;
    }
}
