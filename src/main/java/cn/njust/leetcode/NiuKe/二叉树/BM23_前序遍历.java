package cn.njust.leetcode.NiuKe.二叉树;

import cn.njust.leetcode.JZOffer.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BM23_前序遍历 {

    // 前序遍历
    public int[] preorderTraversal (TreeNode root) {
        // write code here

        if(root==null){
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null) stack.add(node.right);
            if(node.left!=null) stack.add(node.left);
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }


}
