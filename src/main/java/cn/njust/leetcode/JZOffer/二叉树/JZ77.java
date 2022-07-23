package cn.njust.leetcode.JZOffer.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class JZ77 {

    static class TreeNodeL {
        TreeNode root;
        int level;
        public TreeNodeL(TreeNode root,int level){
            this.root = root;
            this.level = level;
        }
    }

    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        // 按照之字型打印二叉树  层序  依据层是奇数还是偶数 决定方向
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
            // 根据 level 是奇数还是偶数  来插入队尾还是队头
            if(level%2==1){
                list.get(level-1).add(node.val);
            }else{
                list.get(level-1).add(0,node.val);
            }
            // 加入队列
            if(node.left!=null){
                q.add(new TreeNodeL(node.left,level+1));
            }
            if(node.right!=null){
                q.add(new TreeNodeL(node.right,level+1));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        TreeNode p3 = new TreeNode(4);
        TreeNode p4 = new TreeNode(5);
        root.left = p1;
        root.right = p2;
        p1.left = p3;
        p2.left = p4;
        ArrayList<ArrayList<Integer>> res = new JZ77().Print(root);
        System.out.println(res);
    }


}
