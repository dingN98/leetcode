package cn.njust.leetcode.JZOffer.二叉树;

public class JZ84_2 {

    // 二叉树内有多少路径的长度等于 sum
    // 路径和 + 树的遍历

    public int FindPath (TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        // 根节点有几条+左孩子有几条+右孩子有几条
        return search(root,sum)+FindPath(root.left,sum)+FindPath(root.right,sum);
    }

    // 起点是指定根节点 有多少路径满足要求
    public int search(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        sum-=root.val;
        if(sum==0){
            // 如果下面是 -1  和  1 是需要继续遍历的
            // 来自牛客的奇葩测试数据  数据有正有负
            return 1+search(root.left,0)+search(root.right,0);
        }
        return search(root.left,sum) + search(root.right,sum);
    }
}
