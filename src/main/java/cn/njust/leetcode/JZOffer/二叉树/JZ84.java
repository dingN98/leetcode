package cn.njust.leetcode.JZOffer.二叉树;

public class JZ84 {

    int res = 0;

    public int FindPath (TreeNode root, int sum) {
        // 二叉树内有多少路径的长度等于 sum
        // 从上往下
        // 根节点有几条+左孩子有几条+右孩子有几条
        searchAll(root,sum);
        return res;
    }

    // 起点是指定根节点 有多少路径满足要求
    public int search(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        sum-=root.val;
        if(sum==0){
            return 1;
        }
        return search(root.left,sum) + search(root.right,sum);
    }

//    // 遍历所有节点
    public void searchAll(TreeNode root,int sum){
        if(root==null){
            return;
        }
        res += search(root,sum);
        searchAll(root.left,sum);
        searchAll(root.right,sum);
    }
}
