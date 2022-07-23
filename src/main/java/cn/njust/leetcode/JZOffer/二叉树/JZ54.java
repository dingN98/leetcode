package cn.njust.leetcode.JZOffer.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

public class JZ54 {

    ArrayList<Integer> list = new ArrayList<>();

    public int KthNode (TreeNode proot, int k) {
        // 二叉搜索树的第k个节点
        // 看题解之前 我的想法是  二叉搜索树+中序遍历=递增数组
        search(proot);
        int len = list.size();
        if(k > len || k <= 0){
            return -1;
        }
        return list.get(k-1);

    }

    public void search(TreeNode root){
        if(root==null){
            return;
        }
        search(root.left);
        list.add(root.val);
        search(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(8);
        root.left = p1;
        root.right = p2;
        int res = new JZ54().KthNode(root,3);
        System.out.println(res);
    }

}
