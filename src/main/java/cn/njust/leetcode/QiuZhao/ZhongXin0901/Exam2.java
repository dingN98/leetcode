package cn.njust.leetcode.QiuZhao.ZhongXin0901;

import com.sun.glass.ui.Size;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Exam2 {

    static  class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public int maxValue (TreeNode root) {
        // write code here

        search(root);
        return res;
    }

    int res = 0;

    public void search(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            TreeNode h1 = root;
            TreeNode h2 = root.left;
            TreeNode tmp1 = h2.left;
            TreeNode tmp2 = h2.right;
            TreeNode tmp3 = root.right;

            h1.left = tmp1;
            h1.right = tmp2;
            h2.left = h1;
            h2.right = tmp3;

            res = Math.max(res,fun(root));

            root.left = h2;
            root.right = tmp3;
            h2.left = tmp1;
            h2.right = tmp2;
        }
        if(root.right!=null){
            TreeNode h1 = root;
            TreeNode h2 = root.right;
            TreeNode tmp1 = h2.left;
            TreeNode tmp2 = h2.right;
            TreeNode tmp3 = root.right;

            h1.left = tmp1;
            h1.right = tmp2;
            h2.left = h1;
            h2.right = tmp3;

            res = Math.max(res,fun(root));

            root.left = h2;
            root.right = tmp3;
            h2.left = tmp1;
            h2.right = tmp2;
        }
        search(root.left);
        search(root.right);
    }

    public int fun(TreeNode root){
        int maxV = 0;
        if(root==null){
            return maxV;
        }
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        TreeNode node = null;
        int sumV = 0;
        int size = 1;

        while(!nodes.isEmpty()){
            node = nodes.poll();
            sumV += node.val;
            size--;
            if(node.left!=null){
                nodes.add(node.left);
            }
            if(node.right!=null){
                nodes.add(node.right);
            }
            if(size==0){
                maxV = Math.max(maxV,sumV);
                sumV = 0;
                size = nodes.size();
            }
        }
        return maxV;
    }
}
