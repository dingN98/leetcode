package cn.njust.leetcode.JZOffer.二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class JZ78 {

    static class TreeNodeL {
        TreeNode root;
        int level;
        public TreeNodeL(TreeNode root,int level){
            this.root = root;
            this.level = level;
        }
    }


    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        // 把二叉树打印成多行 层序遍历
        // 我的想法是 在 TreeNode 外面再包一层，用来记录 node 属于第几层
        search(pRoot);
        return list;
    }

    public void search(TreeNode p){
        if(p==null){
            return;
        }

        Queue<TreeNodeL> q = new ArrayDeque<>();
        q.add(new TreeNodeL(p,1));
        while(!q.isEmpty()){
            TreeNodeL tmp = q.poll();
            TreeNode node = tmp.root;
            int level = tmp.level;
            if(level>list.size()){
                list.add(new ArrayList<>());
            }
            list.get(level-1).add(node.val);
            if(node.left!=null){
                q.add(new TreeNodeL(node.left,level+1));
            }
            if(node.right!=null){
                q.add(new TreeNodeL(node.right,level+1));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(8);
        TreeNode p3 = new TreeNode(8);
        root.left = p1;
        root.right = p2;
        p2.left = p3;
        ArrayList<ArrayList<Integer>> res = new JZ78().Print(root);
        System.out.println(res);
    }

}
