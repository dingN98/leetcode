package cn.njust.leetcode.JZOffer.二叉树;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ7 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {

        // 重建二叉树
        // 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点
        // 中序是必须的，前序或者后序选一个

        // 前序  根左右
        // 中序  左根右
        // 根据前序可以找到根  然后从中序里找到根，根左边是左孩子，根右边是右孩子

        if(pre.length==0 || vin.length==0){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for(int i=0;i<vin.length;i++){
            if(vin[i]==pre[0]){
                // Array.copyOfRange(nums,from,to)  复制数组  包前不包后
                // pre : 0        1~(i+1)                   (i+1)~pre.length

                // vin :          0~i             i         (i+1)~vin.length
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1, i+1),Arrays.copyOfRange(vin,0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(vin,i+1,vin.length));
                break;
            }
        }
        return root;
    }

}
