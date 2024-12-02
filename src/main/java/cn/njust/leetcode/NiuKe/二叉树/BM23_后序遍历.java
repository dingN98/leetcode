package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BM23_后序遍历 {

    ArrayList<Integer> list = new ArrayList<>();

    // 后序遍历
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        search(root);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;

    }

    public void search(TreeNode root){
        if(root==null){
            return;
        }
        search(root.left);
        search(root.right);
        list.add(root.val);
    }

}
