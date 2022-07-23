package cn.njust.leetcode.JZOffer.二叉树;

import java.util.ArrayList;

public class JZ34 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {

        // 二叉树中的路径  和为指定值
        search(root,new ArrayList<>(),expectNumber);
        return res;
    }

    public void search(TreeNode root,ArrayList<Integer> path,int target){
        if(root==null){
            return;
        }
        target-=root.val;
        path.add(root.val);

        if(target==0 && root.left==null && root.right==null){
            res.add(new ArrayList<>(path));
        }
        search(root.left,path,target);
        search(root.right,path,target);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(3);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p2.right = p4;

        ArrayList<ArrayList<Integer>> res = new JZ34().FindPath(root,6);
        System.out.println(res);

    }
}
